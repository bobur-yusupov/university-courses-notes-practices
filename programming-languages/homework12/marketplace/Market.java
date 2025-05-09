package marketplace;

import java.util.ArrayList;
import java.util.List;

import marketplace.droids.*;
import marketplace.persons.Jawa;

public class Market {
    private List<Jawa> sellers;
    
    public Market() {
        this.sellers = new ArrayList<>();
    }

    public void addSeller(Jawa seller) {
        this.sellers.add(seller);
    }

    public int buyDroids(Jawa seller, List<Droid> droidsToBuy) {
        if (!sellers.contains(seller)) {
            throw new IllegalArgumentException("The specified seller is not part of this market.");
        }

        int totalPrice = seller.sellDroid(droidsToBuy);
        System.out.println("Droids purchased for a total price of: " + totalPrice);
        return totalPrice;
    }

    public int buyDroidParts(Jawa seller, List<DroidPart> parts) {
        if (!sellers.contains(seller)) {
            throw new IllegalArgumentException("The specified seller is not part of this market.");
        }

        int totalPrice = seller.sellDroidParts(parts);
        System.out.println("Droid parts purchased for a total price of: " + totalPrice);
        return totalPrice;
    }

    public void displayAvailableDroids(Jawa seller) {
        for (Droid droid : seller.browseDroids()) {
            System.out.println(droid.toString());
        }
    }

    public void displayAvailableParts(Jawa seller) {
        for (DroidPart part : seller.browserDroidParts().keySet()) {
            System.out.println(part.toString());
        }
    }
}