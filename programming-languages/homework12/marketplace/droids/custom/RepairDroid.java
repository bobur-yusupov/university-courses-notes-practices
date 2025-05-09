package marketplace.droids.custom;

import java.util.List;
import java.util.ArrayList;
import java.util.*;

import marketplace.droids.*;

public class RepairDroid extends Droid {
    private int repairAmount;

    public RepairDroid(List<DroidPart> parts, int repairAmount) {
        super(parts);
        this.repairAmount = repairAmount;
    }

    public void repairPart(DroidPart droidPart) {
        droidPart.setDamage(droidPart.getDamage() - 1);
        this.repairAmount += 1;
        this.reducePower(8);
    }

    public void prioritizeRepair(List<DroidPart> parts) {
        parts.sort(Comparator.comparing(DroidPart::getDamage));

        for (DroidPart part : getParts()) {
            this.repairPart(part);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RepairDroid");
        String diagnostics = runDiagnostics();
        sb.append(diagnostics);
        sb.append("Power Level: " + this.getPowerLevel());
        sb.append("Repair amount " + this.repairAmount);

        return sb.toString();
    }
}