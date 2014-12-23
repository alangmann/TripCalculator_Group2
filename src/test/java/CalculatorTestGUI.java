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

    @Before
    public void setUp() {
        gui = new TripCalcGUI();
    }

    //public String getCurrentWeekDay()
    @Test
    public void getCurrentWeekDayMonday()
    {
        Calendar cal = Calendar.getInstance();
        int weekDay = 0;
        assertThat(gui.getCurrentWeekDay(weekDay), equalTo("Monday"));
    }
}