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
            // all purchases are done and the simulation is shutting down
            Thread.currentThread().interrupt();
        }
    }
}
