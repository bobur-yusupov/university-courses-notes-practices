package parking;

import parking.facility.*;
import vehicle.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final Space[][] floorPlan;

    public ParkingLot(int floorNumber, int spaceNumber) {
        if (floorNumber < 1 || spaceNumber < 1) {
            throw new IllegalArgumentException("Floor number and space number must at least 1.");
        }
        this.floorPlan = new Space[floorNumber][spaceNumber];
        for (int i = 0; i < floorNumber; i++) {
            for (int j = 0; j < spaceNumber; j++) {
                this.floorPlan[i][j] = new Space(i, j);
            }
        }
    }

    public Space[][] getFloorPlan() {
        return floorPlan;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Space[] floor : floorPlan) {
            for (Space space : floor) {
                if (!space.isTaken()) {
                    sb.append("X ");
                } else if (space.getOccupyingCarSize() == Size.SMALL) {
                    sb.append("S ");
                } else {
                    sb.append("L ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
