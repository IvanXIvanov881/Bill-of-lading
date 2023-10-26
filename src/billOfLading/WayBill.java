package billOfLading;

public interface WayBill {

    int getNumber();

    double getKilograms();

    double getVolume();

    String getSendFrom();

    String getToDelivery();

    String getStatistics();

    void setToLocation(String newLocation);
}
