package petshop;

import petshop.pet.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class PetShop {
    private AtomicInteger currentVisitors;
    private int revenue;
    private ConcurrentLinkedQueue<Pet> pets;
    private BlockingQueue<CheckoutRequest> checkoutQueue;

    public PetShop() {
        this.currentVisitors = new AtomicInteger(0);
        this.revenue = 0;
        this.pets = new ConcurrentLinkedQueue<>();
        this.checkoutQueue = new LinkedBlockingQueue<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public Pet getRandomPet() {
        // only pets that have not been selected yet are available
        List<Pet> available = new ArrayList<>();
        for (Pet pet : pets) {
            if (!pet.isSelected()) {
                available.add(pet);
            }
        }
        if (available.isEmpty()) {
            return null;
        }
        return available.get(ThreadLocalRandom.current().nextInt(available.size()));
    }

    public void enterShop() {
        currentVisitors.incrementAndGet();
    }

    public void leaveShop() {
        currentVisitors.decrementAndGet();
    }

    public int getCurrentVisitors() {
        return currentVisitors.get();
    }

    public void goToCheckout(CheckoutRequest request)
            throws InterruptedException {
        checkoutQueue.put(request);
    }

    public CheckoutRequest getNextCheckout()
            throws InterruptedException {
        return checkoutQueue.take();
    }

    public synchronized void processCheckout(CheckoutRequest request) {
        Pet pet = request.getPet();
        int price = pet.getPrice();
        revenue += price;
        pets.remove(pet); // the pet goes home with its new family
        System.out.println("[Checkout] " + request.getParent().getName()
                + " bought " + pet.getClass().getSimpleName() + " " + pet
                + " for " + price + " | revenue so far: " + revenue);
        request.markPaid();
    }

    public synchronized int getRevenue() {
        return revenue;
    }
}
