import static org.hamcrest.CoreMatchers.equalTo;
        import bl.*;
import gui.TripCalcGUI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;

import static org.junit.Assert.assertThat;
        import static org.junit.Assert.assertTrue;


public class CalculatorTest
{
    private Calculator calc;
    private TripCalcGUI gui;
    private static double CO2_CONSUMPTION_DIESEL = 0.0265;
    private static double CO2_CONSUMPTION_PETROL = 0.0236;



    @Before
    public void setUp() {
        calc = new Calculator();
    }

    //Highway
    @Test
    public void calculateCo2ConsumptionWithCarDieselHighway()
    {
        //double distance, RouteType typeOfRoute, double specialFee, double slope
        Car c = new Car(FuelType.Diesel, 10, 5);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(1.8259124999999998));
    }

    @Test
    public void calculateCo2ConsumptionWithCarPatrolHighway()
    {
        Car c = new Car(FuelType.Patrol, 10, 5);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(1.6808399999999997));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithoutAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, false, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(1.3756875));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithAdBlueHighway()
    {
    Truck t = new Truck(FuelType.Diesel, 10, 5, true, 2);
    Route r = new Route(10, RouteType.Highway, 5, 5);
    assertThat(calc.calculateCo2Consumption(r, t), equalTo(1.279389375));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithoutAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, false, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(1.230615));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, true, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(1.1444719499999998));
    }

    //CountryRoad
    @Test
    public void calculateCo2ConsumptionWithCarDieselCountryRoad()
    {
        Car c = new Car(FuelType.Diesel, 10, 5);
        Route r = new Route(5, RouteType.CountryRoad, 5,5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(1.0960949999999998));
    }

    @Test
    public void calculateCo2ConsumptionWithCarPatrolCountryRoad()
    {
        Car c = new Car(FuelType.Patrol, 10, 5);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(2.0170079999999997));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithoutAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, false, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(1.650825));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, true, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(1.53526725));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithoutAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, false, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(1.4767379999999999));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, true, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(1.3733663399999998));
    }


    //GravelRoad
    @Test
    public void calculateCo2ConsumptionWithCarDieselGravelRoad()
    {
        Car c = new Car(FuelType.Diesel, 10, 5);
        Route r = new Route(5, RouteType.GravelRoad, 5,5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(1.8268249999999997));
    }

    @Test
    public void calculateCo2ConsumptionWithCarPatrolGravelRoad()
    {
        Car c = new Car(FuelType.Patrol, 10, 5);
        Route r = new Route(10, RouteType.GravelRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(3.3616799999999993));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithoutAdBlueGravelRoad()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, false, 2);
        Route r = new Route(10, RouteType.GravelRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.751375));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithAdBlueGravelRoad()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, true, 2);
        Route r = new Route(10, RouteType.GravelRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.55877875));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithoutAdBlueGravelRoad()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, false, 2);
        Route r = new Route(10, RouteType.GravelRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.46123));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithAdBlueGravelRoad()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, true, 2);
        Route r = new Route(10, RouteType.GravelRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.2889438999999996));
    }

//calculate Costs
   // Route route, Vehicle vehicle, String dayOfWeek, LinkedList<FuelPrices> fuelprices


    @Test
    public void calculateTotalCostOfRouteWithCarHighwayOnMonday()
    {
        String f = new File(System.getProperty("user.dir")).getParent();
        String path = f+ "\\main\\resources\\sprit_db.csv";
        LinkedList<FuelPrices> fuelPricesList = calc.readCSVSprit(path);
        Car c = new Car(FuelType.Diesel, 10, 5);
        Route r = new Route(10, RouteType.Highway, 5, 5);

        assertThat(calc.calculateTotalCostOfRoute(r, c, "Monday", fuelPricesList), equalTo(5.6605));
    }


    @Test
    public void calculateTotalCostOfRouteWithCarCountryRoadOnMonday()
    {
        String f = new File(System.getProperty("user.dir")).getParent();
        String path = f+ "\\main\\resources\\sprit_db.csv";
        LinkedList<FuelPrices> fuelPricesList = calc.readCSVSprit(path);
        Car c = new Car(FuelType.Diesel, 10, 5);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);

        assertThat(calc.calculateTotalCostOfRoute(r, c, "Monday", fuelPricesList), equalTo(5.6605));
    }



    @Test
    public void calculateTotalCostOfRouteWithCarGravelRoadOnMonday()
    {
        String f = new File(System.getProperty("user.dir")).getParent();
        String path = f+ "\\main\\resources\\sprit_db.csv";
        LinkedList<FuelPrices> fuelPricesList = calc.readCSVSprit(path);
        Car c = new Car(FuelType.Diesel, 10, 5);
        Route r = new Route(10, RouteType.Highway, 5, 5);

        assertThat(calc.calculateTotalCostOfRoute(r, c, "Monday", fuelPricesList), equalTo(5.6605));
    }
}