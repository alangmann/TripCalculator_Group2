
import bl.Calculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TripCalculatorTest
{
    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testDummy() {
        assertTrue(true);
    }
}