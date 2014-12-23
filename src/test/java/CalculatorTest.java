import static org.hamcrest.CoreMatchers.equalTo;
        import bl.*;
        import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

        import static org.junit.Assert.assertThat;
        import static org.junit.Assert.assertTrue;


public class CalculatorTest
{
    private Calculator calc;
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
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(18.25));
    }

    @Test
    public void calculateCo2ConsumptionWithCarPatrolHighway()
    {
        Car c = new Car(FuelType.Patrol, 10, 5);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(16.799999999999997));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithoutAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, false, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(13.75));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, true, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(12.787500000000001));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithoutAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, false, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(12.3));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, true, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(11.439));
    }

    //CountryRoad
    @Test
    public void calculateCo2ConsumptionWithCarDieselCountryRoad()
    {
        Car c = new Car(FuelType.Diesel, 10, 5);
        Route r = new Route(5, RouteType.CountryRoad, 0, -300);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(1.752));
    }

    @Test
    public void calculateCo2ConsumptionWithCarPatrolCountryRoad()
    {
        Car c = new Car(FuelType.Patrol, 10, 5);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(16.799999999999997));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithoutAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, false, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(13.75));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, true, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(12.787500000000001));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithoutAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, false, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(12.3));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, true, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(11.439));
    }

}