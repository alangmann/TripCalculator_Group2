import bl.FuelType;
import static org.hamcrest.CoreMatchers.equalTo;
import bl.Truck;
import bl.Vehicle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class VehicleTest
{

    private Vehicle vehicle;

    @Before
    public void setUp() {
        vehicle = new Vehicle(FuelType.Diesel, 5,10);
    }


    @Test
    public void getAvgConsumtptionTo10Point2() {
        assertThat(vehicle.getAverageConsumption(), equalTo(10.0));
    }

    @Test
    public void getCargoTo10() {
        assertEquals(vehicle.getCargo(), 5);
    }

    @Test
    public void getTypeOfFuelToDiesel() {
        assertEquals(vehicle.getTypeOfFuel(), FuelType.Diesel);
    }

    @Test
    public void getTypeOfFuelToPatrol() {
        vehicle = new Vehicle(FuelType.Patrol, 5,10);
        assertEquals(vehicle.getTypeOfFuel(), FuelType.Patrol);
    }


    @Test
    public void setAvgConsumtptionTo10Point2() {
        vehicle = new Vehicle(FuelType.Diesel, 5,20);
        vehicle.setAverageConsumption(10.2);
        assertThat(vehicle.getAverageConsumption(), equalTo(10.2));
    }

    @Test
    public void setCargoTo10() {
        vehicle = new Vehicle(FuelType.Diesel, 30,20);
        vehicle.setCargo(10);
        assertEquals(vehicle.getCargo(), 10);
    }

    @Test
    public void setTypeOfFuelToDiesel() {
        vehicle = new Vehicle(FuelType.Patrol, 10,20);
        vehicle.setTypeOfFuel(FuelType.Diesel);
        assertEquals(vehicle.getTypeOfFuel(), FuelType.Diesel);
    }

    @Test
    public void setTypeOfFuelToPatrol() {
        vehicle = new Vehicle(FuelType.Diesel, 10,20);
        vehicle.setTypeOfFuel(FuelType.Patrol);
        assertEquals(vehicle.getTypeOfFuel(), FuelType.Patrol);
    }



}