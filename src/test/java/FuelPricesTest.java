import bl.*;
import gui.TripCalcGUI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;


public class FuelPricesTest
{

    private FuelPrices fuelprices;

    @Before
    public void setUp() {
        fuelprices = new FuelPrices("Monday", 1.25,1.25);
    }


    @Test
    public void getWeekDay() {

        assertEquals(fuelprices.getWeekDay(), "Monday");
    }

    @Test
    public void setWeekDay() {

        fuelprices.setWeekDay("Tuesday");
        assertEquals(fuelprices.getWeekDay(), "Tuesday");
    }

    @Test
    public void getDieselPrice() {

        assertThat(fuelprices.getDieselPrice(), equalTo(1.25));
    }

    @Test
    public void setDieselPrice() {

        fuelprices.setDieselPrice(10.0);
        assertThat(fuelprices.getDieselPrice(), equalTo(10.0));
    }

    @Test
    public void getPatrolPrice() {

        assertThat(fuelprices.getPatrolPrice(), equalTo(1.25));
    }

    @Test
    public void setPatrolPrice() {

        fuelprices.setPatrolPrice(11.0);
        assertThat(fuelprices.getPatrolPrice(), equalTo(11.0));
    }
}