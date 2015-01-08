import bl.FuelPrices;
import bl.Route;
import bl.RouteType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class RouteTest
{

    private Route route;

    @Before
    public void setUp() {
        route = new Route(10.0, RouteType.Highway, 20.0, 12.00);
    }


    @Test
    public void getDistance() {

        assertThat(route.getDistance(), equalTo(10.0));
    }

    @Test
    public void setDistance() {

        route.setDistance(20.00);
        assertThat(route.getDistance(), equalTo(20.0));
    }


    @Test
    public void getSlope() {

        assertThat(route.getSlope(), equalTo(12.0));
    }

    @Test
    public void setSlope() {

        route.setSlope(20.00);
        assertThat(route.getSlope(), equalTo(20.0));
    }

    @Test
       public void getSpecialFee() {

    assertThat(route.getSpecialFee(), equalTo(20.0));
}

    @Test
    public void setSpecialFee() {

        route.setSpecialFee(10.00);
        assertThat(route.getSpecialFee(), equalTo(10.0));
    }

    @Test
    public void getTypeOfRoute() {

        assertEquals(route.getTypeOfRoute(), RouteType.Highway);
    }

    @Test
    public void setTypeOfRoute() {

        route.setTypeOfRoute(RouteType.CountryRoad);
        assertEquals(route.getTypeOfRoute(), RouteType.CountryRoad);
    }

}