package wildlifesimulation.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTest {
    
    public VehicleTest() {
    }

    @Test
    public void testRefuelVehicle() {
        Vehicle vehicle = new Vehicle("V1" , 0, 50);

        vehicle.refuel(20);
        assertEquals(20, vehicle.getFuelLevel());
    }

    @Test
    public void testDeployVehicle() {
        Vehicle vehicle = new Vehicle("V1" , 50, 50);
        vehicle.deploy();

        assertEquals(40, vehicle.getFuelLevel());
    }
}
