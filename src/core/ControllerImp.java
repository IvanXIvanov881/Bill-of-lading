package core;

import billOfLading.WayBill;

public interface ControllerImp {


    String addWayBillToRepo(WayBill wayBill);

    WayBill getWayBill(String codeOfBill);

    public String getWayStatistic(String codeOfBill);

    int removeWayBillFromRepo(int numberOfWayBill);

    String getStatistics();


}
