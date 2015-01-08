package bl;

/**
 * Created by Yvonne on 27.11.2014.
 */
public class Vehicle
{
    private double averageConsumption;
    private FuelType typeOfFuel;
    private int cargo;

    public Vehicle(FuelType typeOfFuel, int cargo, double averageConsumption) {
        this.typeOfFuel = typeOfFuel;
        this.cargo = cargo;
        this.averageConsumption = averageConsumption;
    }

    public double getAverageConsumption() {
        return averageConsumption;
    }

    public void setAverageConsumption(double averageConsumption) {
        this.averageConsumption = averageConsumption;
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


}
