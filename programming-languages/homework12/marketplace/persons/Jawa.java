package marketplace.persons;

import java.util.*;

import marketplace.droids.*;

public class Jawa implements Seller {
    private List<Droid> droidsInStorage;
    private Map<DroidPart, Integer> partsInStorage;
    private String name;

    public Jawa(String name) {
        this.name = name;
        this.droidsInStorage = new ArrayList<>();
        this.partsInStorage = new HashMap<>();
    }

    public int sellDroid(List<Droid> buyList) {
        int totalPrice = 0;

        for (Droid droid : buyList) {
            if (droidsInStorage.contains(droid)) {
                int sumOfParts = droid.getParts().stream().mapToInt(DroidPart::getPrice).sum();
                totalPrice += sumOfParts;
                droidsInStorage.remove(droid);
            }
        }

        return totalPrice;
    }

    public int sellDroidParts(List<DroidPart> parts) {
        int totalPrice = 0;
        for (DroidPart part : parts) {
            if (partsInStorage.containsKey(part)) {
                totalPrice += part.getPrice();
                int reducedAmount = partsInStorage.get(part) - 1;
                if (reducedAmount == 0) {
                    partsInStorage.remove(part);
                } else {
                    partsInStorage.put(part, reducedAmount);
                }
            }
        }

        return totalPrice - applyDiscount(totalPrice);
    }

    private int applyDiscount(int totalPrice) {
        double discount = haggle();
        if (discount > 0) {
            int discountAmount = (int) (totalPrice * discount);
            return totalPrice - discountAmount;
        }

        return totalPrice;

        int discountAmount = (int) (totalPrice * discount);
        return totalPrice - discountAmount;
    }

    private double haggle() {
        double discount = Math.random();
        if (discount < 0.1) {
            return discount;
        }

        return 0;
    }

    public List<Droid> browseDroids() {
        return Collections.unmodifiableList(droidsInStorage);
    }

    public Map<DroidPart, Integer> browserDroidParts() {
        return Collections.unmodifiableMap(partsInStorage);
    }

    public void addDroidToInventory(Droid droid) {
        droidsInStorage.add(droid);
    }

    public void restockPart(DroidPart partType, int quantity) {
        partsInStorage.put(partType, partsInStorage.getOrDefault(partType, 0) + quantity);
    }

    public boolean checkPartAvailability(DroidPart partType, int quantity) {
        return quantity <= partsInStorage.get(partType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Jawa otherJawa = (Jawa) obj;
        return Objects.equals(name, otherJawa.name);
    }
}