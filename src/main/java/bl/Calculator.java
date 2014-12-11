package bl;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Created by Corinna on 27.11.2014.
 */
public class Calculator
{
    private static double CO2_CONSUMPTION_DIESEL;
    private static double CO2_CONSUMPTION_PETROL;


    public double calculateCo2Consumption(Route route, Vehicle vehicle)
    {
        double factor;
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



        double co2 = route.getDistance() * vehicle.getAverageConsumption() * route.getSlope() * factor;
        return co2;
    }

    public void calculateTotalCostOfRoute(Route route, Vehicle vehicle, String dayOfWeek)
    {

    }


}
