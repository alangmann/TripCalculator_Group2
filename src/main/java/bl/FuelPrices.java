package bl;

/**
 * Created by Corinna on 19.12.2014.
 */

/*
We added this class because we didn't know how to accomplish the task
with the different prices of fuel per weekday
without this class
 */
public class FuelPrices
{
    private String weekDay;
    private double dieselPrice;
    private double patrolPrice;

    public FuelPrices(String weekDay, double dieselPrice, double patrolPrice) {
        this.weekDay = weekDay;
        this.dieselPrice = dieselPrice;
        this.patrolPrice = patrolPrice;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public double getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(double dieselPrice) {
        this.dieselPrice = dieselPrice;
    }

    public double getPatrolPrice() {
        return patrolPrice;
    }

    public void setPatrolPrice(double patrolPrice) {
        this.patrolPrice = patrolPrice;
    }


}

