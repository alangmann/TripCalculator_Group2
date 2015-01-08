package bl;

/**
 * Created by Corinna on 27.11.2014.
 */
public class Route
{
    private double distance;
    private RouteType typeOfRoute;
    private double slope;
    private double specialFee;

    public Route(double distance, RouteType typeOfRoute, double specialFee, double slope) {
        this.distance = distance;
        this.typeOfRoute = typeOfRoute;
        this.specialFee = specialFee;
        this.slope = slope;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public RouteType getTypeOfRoute() {
        return typeOfRoute;
    }

    public void setTypeOfRoute(RouteType typeOfRoute) {
        this.typeOfRoute = typeOfRoute;
    }

    public double getSpecialFee() {
        return specialFee;
    }

    public void setSpecialFee(double specialFee) {
        this.specialFee = specialFee;
    }
}
