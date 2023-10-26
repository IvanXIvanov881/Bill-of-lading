package billOfLading;

public class FragileLoad extends WayBillBase {
    public FragileLoad(int numberOfWayBill, double kilograms, double volume, String sendLocation, String toLocation) {
        super(numberOfWayBill, kilograms, volume,  sendLocation, toLocation);
    }

    @Override
    public void setToLocation(String newLocation) {
        toLocation = newLocation;
    }
}
