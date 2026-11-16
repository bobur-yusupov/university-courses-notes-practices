package petshop;

public class Cashier implements Runnable {
    private PetShop petShop;

    public Cashier(PetShop petShop) {
        this.petShop = petShop;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                CheckoutRequest request = petShop.getNextCheckout();
                petShop.processCheckout(request);
            }
        } catch (InterruptedException e) {
            // the simulation is shutting down: finish the payments already in the queue
            CheckoutRequest remaining;
            while ((remaining = petShop.pollCheckout()) != null) {
                petShop.processCheckout(remaining);
            }
            Thread.currentThread().interrupt();
        }
    }
}
