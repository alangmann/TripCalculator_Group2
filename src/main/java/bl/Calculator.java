package bl;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Created by Corinna on 27.11.2014.
 */
public class Calculator
{
    private static double CO2_CONSUMPTION_DIESEL = 0.0265;
    private static double CO2_CONSUMPTION_PETROL = 0.0236;


    public double calculateCo2Consumption(Route route, Vehicle vehicle)
    {
        double factor;
        double co2Consumption = -1;
        double resultCo2 = -1;

        if(vehicle instanceof Car)
        {
            if(vehicle.getTypeOfFuel().equals(FuelType.Diesel))
            {
                co2Consumption = vehicle.getAverageConsumption()*CO2_CONSUMPTION_DIESEL;
            }
            else if(vehicle.getTypeOfFuel().equals(FuelType.Patrol))
            {
                co2Consumption = vehicle.getAverageConsumption()*CO2_CONSUMPTION_PETROL;
            }

            double co2ConsumptionsNeu = 0.0005*vehicle.getCargo();

            System.out.println(route.getTypeOfRoute().toString());
            if(route.getSlope() < 0)
            {
                return 0;
            }
            if(route.getTypeOfRoute().equals("Highway"))
            {
                factor = 1;
            }
            else if(route.getTypeOfRoute().equals("CountryRoad")){factor = 1.2;}
            else
            {
                factor = 2;
            }

            resultCo2 = route.getDistance() * (co2Consumption + co2ConsumptionsNeu) * route.getSlope() * factor;
            /**
             * 0,05 l mehr pro 100kg
             * 0,0005 l mehr pro 1kg
             */
        }
        else if(vehicle instanceof Truck)
        {
            if(vehicle.getTypeOfFuel().equals(FuelType.Diesel))
            {
                co2Consumption = vehicle.getAverageConsumption()*CO2_CONSUMPTION_DIESEL;
            }
            else if(vehicle.getTypeOfFuel().equals(FuelType.Patrol))
            {
                co2Consumption = vehicle.getAverageConsumption()*CO2_CONSUMPTION_PETROL;
            }

            double co2ConsumptionsNeu = 0.0005*vehicle.getCargo();



            System.out.println(route.getTypeOfRoute().toString());
            if(route.getSlope() < 0)
            {
                return 0;
            }
            if(route.getTypeOfRoute().equals("Highway"))
            {
                factor = 1;
            }
            else if(route.getTypeOfRoute().equals("CountryRoad")){factor = 1.2;}
            else
            {
                factor = 2;
            }

            if(((Truck) vehicle).isAdBlue())
            {
                resultCo2 = route.getDistance() * ((co2Consumption + co2ConsumptionsNeu)/100*93) * route.getSlope() * factor;
            }
            else
            {
                resultCo2 = route.getDistance() * (co2Consumption + co2ConsumptionsNeu) * route.getSlope() * factor;
            }
        }

        return resultCo2;
    }

    public void calculateTotalCostOfRoute(Route route, Vehicle vehicle, String dayOfWeek)
    {



    }


}
