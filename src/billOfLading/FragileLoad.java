package billOfLading;

public class FragileLoad extends WayBillBase {

    private static final double PRICE_INDEX_FRAGILE = 1.5;

    public FragileLoad(String numberOfWayBill, double kilograms, double volume, String sendLocation, String toLocation) {
        super(numberOfWayBill, kilograms, volume,  sendLocation, toLocation, PRICE_INDEX_FRAGILE);
    }

    @Override
    public void setToLocation(String newLocation) {
        toLocation = newLocation;
    }
}
