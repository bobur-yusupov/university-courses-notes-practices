package petshop;

import petshop.customer.Parent;
import petshop.pet.Pet;

import java.util.concurrent.CountDownLatch;

public class CheckoutRequest {
    private final Parent parent;
    private final Pet pet;
    // released by the cashier once the payment has been processed
    private final CountDownLatch paid = new CountDownLatch(1);

    public CheckoutRequest(Parent parent, Pet pet) {
        this.parent = parent;
        this.pet = pet;
    }

    public Parent getParent() {
        return parent;
    }

    public Pet getPet() {
        return pet;
    }

    void markPaid() {
        paid.countDown();
    }

    public void awaitPayment() throws InterruptedException {
        paid.await();
    }
}
