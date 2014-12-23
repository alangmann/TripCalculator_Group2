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
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(3.6518249999999997));
    }

    @Test
    public void calculateCo2ConsumptionWithCarPatrolHighway()
    {
        Car c = new Car(FuelType.Patrol, 10, 5);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(3.3616799999999993));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithoutAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, false, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.751375));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithAdBlueHighway()
    {
    Truck t = new Truck(FuelType.Diesel, 10, 5, true, 2);
    Route r = new Route(10, RouteType.Highway, 5, 5);
    assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.55877875));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithoutAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, false, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.46123));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithAdBlueHighway()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, true, 2);
        Route r = new Route(10, RouteType.Highway, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.2889438999999996));
    }

    //CountryRoad
    @Test
    public void calculateCo2ConsumptionWithCarDieselCountryRoad()
    {
        Car c = new Car(FuelType.Diesel, 10, 5);
        Route r = new Route(5, RouteType.CountryRoad, 5,5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(1.8268249999999997));
    }

    @Test
    public void calculateCo2ConsumptionWithCarPatrolCountryRoad()
    {
        Car c = new Car(FuelType.Patrol, 10, 5);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, c), equalTo(3.3616799999999993));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithoutAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, false, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.751375));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckDieselWithAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Diesel, 10, 5, true, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.55877875));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithoutAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, false, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.46123));
    }

    @Test
    public void calculateCo2ConsumptionWithTruckPatrolWithAdBlueCountryRoad()
    {
        Truck t = new Truck(FuelType.Patrol, 10, 5, true, 2);
        Route r = new Route(10, RouteType.CountryRoad, 5, 5);
        assertThat(calc.calculateCo2Consumption(r, t), equalTo(2.2889438999999996));
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

}