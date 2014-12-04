package bl;

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

    private LinkedList<Route> routeList = new LinkedList<Route>();

    public void calculateCo2Consumption(Route route, Vehicle vehicle)
    {

    }

    public void calculateTotalCostOfRoute(Route route, Vehicle vehicle, String dayOfWeek)
    {

    }

    public void init()
    {
        BufferedReader br;
        int i = 0;
        try {

            String pathName = System.getProperty("user.dir")+ File.separator+ "src" + File.separator + "main"+
                    File.separator + "resources" + File.separator+"routes.csv";

            br = new BufferedReader(new FileReader(pathName));


            String str = "";
            String[] strArray;

            while ((str = br.readLine()) != null)
            {
                if(i!= 0)
                {
                    strArray = str.split(";");

                    Route route = new Route(Double.parseDouble(strArray[0]), RouteType.valueOf(strArray[2]),
                            Double.parseDouble(strArray[3]), Double.parseDouble(strArray[1]));

                    routeList.add(route);
                }

                i++;


            }
            br.close();

        } catch (Exception ex) {}


    }
}
