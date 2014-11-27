package bl;

/**
 * Created by Yvonne on 27.11.2014.
 */
public class Truck
{
    private int axies; 
    private boolean adBlue;

    public Truck(boolean adBlue, int axies) {
        this.adBlue = adBlue;
        this.axies = axies;
    }

    public int getAxies() {
        return axies;
    }

    public void setAxies(int axies) {
        this.axies = axies;
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
        if (axies != truck.axies) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = axies;
        result = 31 * result + (adBlue ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "axies=" + axies +
                ", adBlue=" + adBlue +
                '}';
    }
}
