package bl;

/**
 * Created by Yvonne on 27.11.2014.
 */
public class Truck extends Vehicle
{
    private int axles;
    private boolean adBlue;

    public Truck(FuelType typeOfFuel, int cargo, double averageConsumption, boolean adBlue, int axles) {
        super(typeOfFuel, cargo, averageConsumption);
        this.adBlue = adBlue;
        this.axles = axles;
    }

    public int getAxles() {
        return axles;
    }

    public void setAxles(int axles) {
        this.axles = axles;
    }

    public boolean isAdBlue() {
        return adBlue;
    }

    public void setAdBlue(boolean adBlue) {
        this.adBlue = adBlue;
    }
}
