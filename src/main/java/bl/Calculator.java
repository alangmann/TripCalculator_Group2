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

    private LinkedList<Route> routeList = new LinkedList<Route>();
    private LinkedList<FuelPrices> fuelPricesList = new LinkedList<FuelPrices>();


    public double calculateCo2Consumption(Route route, Vehicle vehicle)
    {
        double factor = -1;
        double co2Consumption = -1;
        double resultCo2 = -1;
        double slope = route.getSlope()/(route.getDistance()*1000)+1;

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

            double co2ConsumptionsNeu = 0.005*vehicle.getCargo();
            if(route.getSlope() < 0)
            {
                return 0;
            }

            if(route.getTypeOfRoute().equals(RouteType.Highway))
            {
                factor = 1;
            }
            else if(route.getTypeOfRoute().equals(RouteType.CountryRoad))
            {
                factor = 1.2;
            }
            else if(route.getTypeOfRoute().equals(RouteType.GravelRoad))
            {
                factor = 2;
            }

            resultCo2 = route.getDistance() * (co2Consumption + co2ConsumptionsNeu) * slope * factor;
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


            if(route.getSlope() < 0)
            {
                return 0;
            }
            if(route.getTypeOfRoute().equals(RouteType.Highway))
            {
                factor = 1;
            }
            else if(route.getTypeOfRoute().equals(RouteType.CountryRoad))
            {
                factor = 1.2;
            }
            else if(route.getTypeOfRoute().equals(RouteType.GravelRoad))
            {
                factor = 2;
            }

            if(((Truck) vehicle).isAdBlue())
            {
                resultCo2 = route.getDistance() * ((co2Consumption + co2ConsumptionsNeu)/100*93) * slope * factor;
            }
            else
            {
                resultCo2 = route.getDistance() * (co2Consumption + co2ConsumptionsNeu) * slope * factor;
            }
        }

        return resultCo2;
    }

    //parameter "fuelprices" hinzugefügt, weicht deshalb vom Klassendiagramm ab
    public double calculateTotalCostOfRoute(Route route, Vehicle vehicle, String dayOfWeek, LinkedList<FuelPrices> fuelprices)
    {
        double cost = 0;

        for(FuelPrices f : fuelprices)
        {
            if(f.getWeekDay().equals(dayOfWeek))
            {
                double distance = route.getDistance();
                double averageConsumptionOneKm = vehicle.getAverageConsumption()/100;


                if(vehicle.getTypeOfFuel().equals(FuelType.Diesel))
                {
                    cost+=averageConsumptionOneKm*distance*f.getDieselPrice();

                }
                else if(vehicle.getTypeOfFuel().equals(FuelType.Patrol))
                {
                    cost+=averageConsumptionOneKm*distance*f.getPatrolPrice();

                }

                if(route.getSpecialFee() != 0)
                {
                    if(vehicle instanceof Truck)
                    {
                        cost+=(route.getSpecialFee()*((Truck) vehicle).getAxles()*1.5);
                    }
                    else if(vehicle instanceof Car)
                    {
                        cost+=route.getSpecialFee();
                    }
                }
            }
        }

        return cost;
    }



    public LinkedList readCSVRoutes()
    {
        BufferedReader br;
        int i = 0;
        try {

            String pathName = System.getProperty("user.dir")+ "\\trunk\\src\\main\\resources\\routes.csv";

            br = new BufferedReader(new FileReader(pathName));


            String str = "";
            String[] strArray;

            while ((str = br.readLine()) != null)
            {
                if(i!= 0)
                {
                    strArray = str.split(";");

                    Route r = new Route(Double.parseDouble(strArray[0].replace(",",".")), RouteType.valueOf(strArray[2]),
                            Double.parseDouble(strArray[3].replace(",",".")), Double.parseDouble(strArray[1].replace(",",".")));

                    routeList.add(r);
                }
                i++;
            }
            br.close();


        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());

        }
        return routeList;
    }

    public LinkedList readCSVSprit()
    {
        BufferedReader br;
        int i = 0;
        try {

            String pathName = System.getProperty("user.dir")+ "\\trunk\\src\\main\\resources\\sprit_db.csv";

            br = new BufferedReader(new FileReader(pathName));


            String str = "";
            String[] strArray;

            while ((str = br.readLine()) != null)
            {
                if(i!= 0)
                {
                    strArray = str.split(";");

                    FuelPrices fuelP = new FuelPrices(strArray[0], Double.parseDouble(strArray[1].replace(",",".")), Double.parseDouble(strArray[2].replace(",",".")));

                    fuelPricesList.add(fuelP);

                }
                i++;

            }
            br.close();

        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());

        }
        return fuelPricesList;
    }

    public LinkedList<FuelPrices> getFuelPricesList() {

        return fuelPricesList;
    }
}
