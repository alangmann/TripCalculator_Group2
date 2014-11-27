package bl;

/**
 * Created by Yvonne on 27.11.2014.
 */
public class Vehicle
{
    private double averageConsumotion;
    private FuelType typeOfFuel;
    private int cargo;

    public Vehicle(FuelType typeOfFuel, int cargo, double averageConsumotion) {
        this.typeOfFuel = typeOfFuel;
        this.cargo = cargo;
        this.averageConsumotion = averageConsumotion;
    }

    public double getAverageConsumotion() {
        return averageConsumotion;
    }

    public void setAverageConsumotion(double averageConsumotion) {
        this.averageConsumotion = averageConsumotion;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public FuelType getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(FuelType typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (Double.compare(vehicle.averageConsumotion, averageConsumotion) != 0) return false;
        if (cargo != vehicle.cargo) return false;
        if (typeOfFuel != vehicle.typeOfFuel) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(averageConsumotion);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (typeOfFuel != null ? typeOfFuel.hashCode() : 0);
        result = 31 * result + cargo;
        return result;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "averageConsumotion=" + averageConsumotion +
                ", typeOfFuel=" + typeOfFuel +
                ", cargo=" + cargo +
                '}';
    }
}
