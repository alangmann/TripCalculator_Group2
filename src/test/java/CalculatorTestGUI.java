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


}