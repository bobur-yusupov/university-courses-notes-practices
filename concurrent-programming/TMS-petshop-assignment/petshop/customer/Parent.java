package petshop.customer;

import petshop.CheckoutRequest;
import petshop.PetShop;
import petshop.pet.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public class Parent extends Customer {
    private int numberOfChildren;
    private BlockingQueue<Pet> selectedPets;
    private CountDownLatch timeToGoHome;
    private CountDownLatch childrenFinishedChoosing;

    public Parent(String name, PetShop petShop, int numberOfChildren) {
        super(name, petShop);
        this.numberOfChildren = numberOfChildren;
        this.selectedPets = new LinkedBlockingQueue<>();
        this.timeToGoHome = new CountDownLatch(1);
        this.childrenFinishedChoosing = new CountDownLatch(numberOfChildren);
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void addSelectedPet(Pet pet) throws InterruptedException {
        selectedPets.put(pet);
    }

    public void childFinishedChoosing() {
        childrenFinishedChoosing.countDown();
    }

    public void awaitFamilyFinished() throws InterruptedException {
        timeToGoHome.await();
    }

    @Override
    public void run() {
        petShop.enterShop();
        System.out.println(name + " entered the shop with " + numberOfChildren + " child(ren)");
        try {
            // wait until every child has finished choosing
            childrenFinishedChoosing.await();

            // all children have put their pet (if any) into the queue before counting down,
            // so we can take pets until the queue is empty
            List<CheckoutRequest> requests = new ArrayList<>();
            while (!selectedPets.isEmpty()) {
                Pet pet = selectedPets.take();
                CheckoutRequest request = new CheckoutRequest(this, pet);
                petShop.goToCheckout(request);
                requests.add(request);
            }
            System.out.println(name + " is paying for " + requests.size() + " pet(s)");

            // wait until the cashier has processed every payment of this family
            for (CheckoutRequest request : requests) {
                request.awaitPayment();
            }
            System.out.println(name + " paid for everything, time to go home");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // tell the children it is time to go home
            timeToGoHome.countDown();
            petShop.leaveShop();
            System.out.println(name + " left the shop");
        }
    }
}
