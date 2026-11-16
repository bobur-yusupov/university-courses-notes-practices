package petshop;

import petshop.customer.Parent;
import petshop.pet.Pet;

public class CheckoutRequest {
    private Parent parent;
    private Pet pet;

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
}