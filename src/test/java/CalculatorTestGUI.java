import bl.*;
import gui.TripCalcGUI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class CalculatorTestGUI
{
    private TripCalcGUI gui;

    @Before
    public void setUp() {
        gui = new TripCalcGUI();
    }

/**
    @Test
    public void testIfReadCSVRoutesReturnsNoError()
    {
        String pathRoutes = System.getProperty("user.dir")+ File.separator+ "trunk"+ File.separator+ "src" + File.separator + "main"+
                File.separator + "resources" + File.separator+"routes.csv";
        boolean load = gui.readCSVRoutes(pathRoutes);
        Assert.assertTrue(load);
    }

    @Test
    public void testIfReadCSVSpritReturnsNoError()
    {
        String pathSprit = System.getProperty("user.dir")+ File.separator+ "trunk"+File.separator+ "src" + File.separator + "main"+
                File.separator + "resources" + File.separator+"sprit_db.csv";
        boolean load = gui.readCSVSprit(pathSprit);
        Assert.assertTrue(load);
    }

    **/

}