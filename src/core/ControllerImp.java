package core;

public interface ControllerImp {


    String addWayBillToRepo(int numberOfWayBill,double kilograms,String currentLocation,String toLocation);

    int removeWayBillFromRepo(int numberOfWayBill);

    String getStatistics();


}
