import petshop.Cashier;
import petshop.PetShop;
import petshop.State;
import petshop.customer.Child;
import petshop.customer.Parent;
import petshop.pet.ChineseHamster;
import petshop.pet.CornSnake;
import petshop.pet.GuineaPig;
import petshop.pet.Pet;
import petshop.pet.SenegalParrot;
import petshop.pet.TurkishAngora;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. create the PetShop
        PetShop petShop = new PetShop();

        // 2. create the pets and add them to the shop
        List<Pet> pets = List.of(
                new CornSnake("Kaa", 2, State.FINE),
                new CornSnake("Slinky", 1, State.SLEEPY),
                new ChineseHamster("Peanut", 1, State.PLAYFUL),
                new ChineseHamster("Mochi", 2, State.FINE),
                new GuineaPig("Pip", 3, State.FINE),
                new GuineaPig("Biscuit", 2, State.STRESSED),
                new SenegalParrot("Polly", 5, State.PLAYFUL),
                new TurkishAngora("Snow", 4, State.SLEEPY)
        );
        for (Pet pet : pets) {
            petShop.addPet(pet);
        }

        // 3. create the cashier, the parents and their children (all before starting anything)
        Cashier cashier = new Cashier(petShop);

        Parent anna = new Parent("Anna", petShop, 2);
        Parent david = new Parent("David", petShop, 3);
        Parent maria = new Parent("Maria", petShop, 1);
        List<Parent> parents = List.of(anna, david, maria);

        List<Child> children = List.of(
                new Child("Emma", anna),
                new Child("Leo", anna),
                new Child("Mia", david),
                new Child("Noah", david),
                new Child("Lily", david),
                new Child("Max", maria)
        );

        if (pets.size() < children.size()) {
            throw new IllegalStateException("There must be at least as many pets as children");
        }

        // 4. one thread per task: every task blocks at some point, so a smaller pool could deadlock
        int taskCount = pets.size() + 1 + parents.size() + children.size();
        ExecutorService executor = Executors.newFixedThreadPool(taskCount);

        // 5. submit the pets, the cashier, the parents and the children
        for (Pet pet : pets) {
            executor.submit(pet);
        }
        executor.submit(cashier);

        List<Future<?>> customerTasks = new ArrayList<>();
        for (Parent parent : parents) {
            customerTasks.add(executor.submit(parent));
        }
        for (Child child : children) {
            customerTasks.add(executor.submit(child));
        }

        // 6. wait until all customer tasks have finished
        for (Future<?> task : customerTasks) {
            try {
                task.get();
            } catch (ExecutionException e) {
                System.err.println("A customer task failed: " + e.getCause());
            }
        }

        // 7. stop the pets and the cashier (the cashier finishes queued payments first)
        executor.shutdownNow();

        // 8. wait for termination
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.err.println("Some tasks did not terminate in time");
        }

        // 9. print the daily revenue
        System.out.println("Visitors still in the shop: " + petShop.getCurrentVisitors());
        System.out.println("Total revenue for the day: " + petShop.getRevenue());
    }
}
