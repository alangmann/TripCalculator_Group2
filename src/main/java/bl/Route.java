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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;

        Route route = (Route) o;

        if (Double.compare(route.distance, distance) != 0) return false;
        if (Double.compare(route.slope, slope) != 0) return false;
        if (Double.compare(route.specialFee, specialFee) != 0) return false;
        if (typeOfRoute != null ? !typeOfRoute.equals(route.typeOfRoute) : route.typeOfRoute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(distance);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (typeOfRoute != null ? typeOfRoute.hashCode() : 0);
        temp = Double.doubleToLongBits(slope);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(specialFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "distance=" + distance +
                ", typeOfRoute=" + typeOfRoute +
                ", slope=" + slope +
                ", specialFee=" + specialFee +
                '}';
    }
}
