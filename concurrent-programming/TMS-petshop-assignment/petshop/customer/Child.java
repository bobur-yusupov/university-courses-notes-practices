package petshop.customer;

import petshop.pet.Pet;

import java.util.concurrent.ThreadLocalRandom;

public class Child extends Customer {
    private Parent parent;

    public Child(String name, Parent parent) {
        super(name, parent.getPetShop());
        this.parent = parent;
    }

    public Parent getParent() {
        return parent;
    }

    @Override
    public void run() {
        petShop.enterShop();
        try {
            // look around for 1-3 seconds
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3001));

            // keep trying until a not-yet-selected pet is found
            Pet selectedPet = null;
            while (selectedPet == null && !Thread.currentThread().isInterrupted()) {
                Pet candidate = petShop.getRandomPet();
                if (candidate == null) {
                    break; // no pets available at all
                }
                if (candidate.select()) {
                    selectedPet = candidate;
                }
            }

            if (selectedPet != null) {
                parent.addSelectedPet(selectedPet);
                System.out.println(name + " chose " + selectedPet);
            } else {
                System.out.println(name + " could not find a pet");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            parent.childFinishedChoosing();
            try {
                parent.awaitFamilyFinished();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            petShop.leaveShop();
        }
    }
}
