package billOfLading;

public interface WayBill {

    String getNumber();

    double getKilograms();

    double getVolume();

    double getPriceIndex();

    String getSendFrom();

    String getToDelivery();

    String getStatistics();

    void setToLocation(String newLocation);


}
