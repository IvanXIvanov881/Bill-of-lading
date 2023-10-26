package billOfLading;

public class FragileLoad extends WayBillBase {

    private static final double PRICE_INDEX = 1.5;

    public FragileLoad(String numberOfWayBill, double kilograms, double volume, String sendLocation, String toLocation) {
        super(numberOfWayBill, kilograms, volume,  sendLocation, toLocation, PRICE_INDEX);
    }

    @Override
    public void setToLocation(String newLocation) {
        toLocation = newLocation;
    }
}
