package marketplace.droids;

import java.util.List;
import java.util.ArrayList;

public class Droid {
    private List<DroidPart> parts;
    private int powerLevel;

    public Droid(List<DroidPart> parts) {
        this.parts = parts;
        this.powerLevel = 100;
    }

    public List<DroidPart> getParts() {
        return parts;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void damagePart(DroidPart part, int damage) {
        if (parts.contains(part)) {
            part.setDamage(part.getDamage() + damage);
        }
    }

    public void charge(int chargeAmount) {
        powerLevel += chargeAmount;
        if (powerLevel > 100) {
            powerLevel = 100;
        }
    }

    public String runDiagnostics() {
        StringBuilder diagnostics = new StringBuilder();
        
        for (DroidPart part : this.parts) {
            diagnostics.append("Part: " + part.getType() + ", Damage: " + part.getDamage() + "\n");
        }

        return diagnostics.toString();
    }

    public void reducePower(int amount) {
        powerLevel -= amount;
        if (powerLevel < 0) {
            powerLevel = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Droid");
        String diagnostics = runDiagnostics();
        sb.append(diagnostics);

        return sb.toString();
    }
}