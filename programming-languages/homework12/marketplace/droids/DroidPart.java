package marketplace.droids;

public class DroidPart {
    private int basePrice;
    private int damage;
    private DroidPartTypes type;

    public DroidPart(int basePrice, int damage, DroidPartTypes type) {
        this.basePrice = basePrice;
        this.damage = damage;
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0 || damage > 100) {
            throw new IllegalArgumentException("Damage must be between 0 and 100");
        }
        
        this.damage = damage;
    }

    public int getPrice() {
        return basePrice - (basePrice * damage / 100);
    }

    public int getRepairCost() {
        return basePrice * damage / 100;
    }

    public DroidPartTypes getType() {
        return type;
    }

    public void upgrade(int priceIncrease) {
        basePrice += priceIncrease;
    }

    @Override
    public String toString() {
        return "DroidPart{" +
                "basePrice=" + basePrice +
                ", damage=" + damage +
                ", type=" + type +
                '}';
    }
}