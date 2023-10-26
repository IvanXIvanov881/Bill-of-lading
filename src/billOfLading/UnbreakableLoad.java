package billOfLading;

public class UnbreakableLoad extends WayBillBase {

    private static final double PRICE_INDEX_UNBREAKABLE = 1.1;

    public UnbreakableLoad(String numberOfWayBill, double kilograms, double volume, String sendLocation, String toLocation) {
        super(numberOfWayBill, kilograms, volume, sendLocation, toLocation, PRICE_INDEX_UNBREAKABLE);
    }

    @Override
    public void setToLocation(String newLocation) {
        toLocation = newLocation;
    }
}
