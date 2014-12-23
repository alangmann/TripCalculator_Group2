import bl.*;
import gui.TripCalcGUI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class CalculatorTestGUI
{
    private TripCalcGUI gui;
    private String f = new File(System.getProperty("user.dir")).getParent();
    private String rPath = f+ "\\main\\resources\\routes.csv";
    private String sPath = f+ "\\main\\resources\\sprit_db.csv";

    @Before
    public void setUp() {
        gui = new TripCalcGUI(rPath, sPath);
    }

    //public String getCurrentWeekDay()
    @Test
    public void getCurrentWeekDayMonday()
    {
        Calendar cal = Calendar.getInstance();
        int weekDay = 0;
        assertThat(gui.getCurrentWeekDay(weekDay), equalTo("Monday"));
    }

    @Test
    public void getCurrentWeekDayTuesday()
    {
        Calendar cal = Calendar.getInstance();
        int weekDay = 1;
        assertThat(gui.getCurrentWeekDay(weekDay), equalTo("Tuesday"));
    }

    @Test
    public void getCurrentWeekDayWednesday()
    {
        Calendar cal = Calendar.getInstance();
        int weekDay = 2;
        assertThat(gui.getCurrentWeekDay(weekDay), equalTo("Wednesday"));
    }

    @Test
    public void getCurrentWeekDayThursday()
    {
        Calendar cal = Calendar.getInstance();
        int weekDay = 3;
        assertThat(gui.getCurrentWeekDay(weekDay), equalTo("Thursday"));
    }
    @Test
    public void getCurrentWeekDayFriday()
    {
        Calendar cal = Calendar.getInstance();
        int weekDay = 4;
        assertThat(gui.getCurrentWeekDay(weekDay), equalTo("Friday"));
    }
    @Test
    public void getCurrentWeekDaySaturday()
    {
        Calendar cal = Calendar.getInstance();
        int weekDay = 5;
        assertThat(gui.getCurrentWeekDay(weekDay), equalTo("Saturday"));
    }
    @Test
    public void getCurrentWeekDaySunday()
    {
        Calendar cal = Calendar.getInstance();
        int weekDay = 6;
        assertThat(gui.getCurrentWeekDay(weekDay), equalTo("Sunday"));
    }

    //Car
    @Test (expected = Exception.class)
    public void datenAutoEinlesenFuelConsumptionNull()
    {
        gui.datenAutoEinlesen(null, "100");
    }

    @Test (expected = Exception.class)
    public void datenAutoEinlesenFuelConsumptionEmpty()
    {
        gui.datenAutoEinlesen("", "100");
    }

    @Test (expected = Exception.class)
    public void datenAutoEinlesenCargoNull()
    {
        gui.datenAutoEinlesen("5", null);
    }

    @Test (expected = Exception.class)
    public void datenAutoEinlesenFuelCargoEmpty()
    {
        gui.datenAutoEinlesen("5", "");
    }

    //Truck
    @Test (expected = Exception.class)
    public void datenTruckEinlesenFuelConsumptionNull()
    {
        //datenTruckEinlesen(fuelConsumption, cargo, axles);
        gui.datenTruckEinlesen(null, "100", "2");
    }

    @Test (expected = Exception.class)
    public void datenTruckEinlesenFuelConsumptionEmpty()
    {
        gui.datenTruckEinlesen("", "100", "2");
    }

    @Test (expected = Exception.class)
    public void datenTruckEinlesenCargoNull()
    {
        gui.datenTruckEinlesen("15", null, "2");
    }

    @Test (expected = Exception.class)
    public void datenTruckEinlesenCargoEmpty()
    {
        gui.datenTruckEinlesen("15", "", "2");
    }

    @Test (expected = Exception.class)
    public void datenTruckEinlesenAxlesNull()
    {
        gui.datenTruckEinlesen("15", "100", null);
    }

    @Test (expected = Exception.class)
    public void datenTruckEinlesenAxlesEmpty()
    {
        gui.datenTruckEinlesen("15", "100", "");
    }
}