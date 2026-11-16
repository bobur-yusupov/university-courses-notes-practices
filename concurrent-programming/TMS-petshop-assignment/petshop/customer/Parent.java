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
    private BlockingQueue<Boolean> familyFinished;
    private CountDownLatch childrenFinishedChoosing;

    public Parent(String name, PetShop petShop, int numberOfChildren) {
        super(name, petShop);
        this.numberOfChildren = numberOfChildren;
        this.selectedPets = new LinkedBlockingQueue<>();
        this.familyFinished = new LinkedBlockingQueue<>();
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
        familyFinished.take();
    }

    @Override
    public void run() {
        petShop.enterShop();
        System.out.println(name + " entered the shop with " + numberOfChildren + " child(ren)");
        try {
            // wait until every child has finished choosing
            childrenFinishedChoosing.await();

            // all children have put their pet (if any) into the queue before counting down
            List<Pet> pets = new ArrayList<>();
            selectedPets.drainTo(pets);

            for (Pet pet : pets) {
                petShop.goToCheckout(new CheckoutRequest(this, pet));
            }
            System.out.println(name + " paid for " + pets.size() + " pet(s): " + pets);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // one token per child: time to go home
            for (int i = 0; i < numberOfChildren; i++) {
                familyFinished.offer(Boolean.TRUE);
            }
            petShop.leaveShop();
            System.out.println(name + " left the shop");
        }
    }
}
