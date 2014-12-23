import bl.*;
import gui.TripCalcGUI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;


public class TruckTest
{

    private Truck truck;

    @Before
    public void setUp() {
        truck = new Truck(FuelType.Diesel, 5,10,false,2);
    }




    @Test
    public void isAdBlueReturnsFalse() {
        truck = new Truck(FuelType.Diesel, 5,10,false,2);
        assertFalse(truck.isAdBlue());
    }


    @Test
    public void isAdBlueReturnsTrue() {
        truck = new Truck(FuelType.Diesel, 5,10,true,2);
        assertTrue(truck.isAdBlue());
    }



    @Test
    public void getAxlesReturns4() {
        truck = new Truck(FuelType.Diesel, 5,10,true,4);
        assertEquals(truck.getAxles(), 4);
    }


    @Test
    public void setAxlesReturns10() {
        truck = new Truck(FuelType.Diesel, 5,10,true,4);
        truck.setAxles(10);
        assertEquals(truck.getAxles(), 10);
    }

    @Test
    public void setAdBlueToFalse() {
        truck = new Truck(FuelType.Diesel, 5,10,true,4);
        truck.setAdBlue(false);

        assertFalse(truck.isAdBlue());
    }



}