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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;

        Truck truck = (Truck) o;

        if (adBlue != truck.adBlue) return false;
        if (axles != truck.axles) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = axles;
        result = 31 * result + (adBlue ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "axies=" + axles +
                ", adBlue=" + adBlue +
                '}';
    }
}
