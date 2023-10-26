package core;

import billOfLading.WayBill;

public interface ControllerIm {

    void addWayBillToRepo(WayBill wayBill);

    boolean removeWayBillToRepo(String codeOfWayBill);

    WayBill getWayBill(String codeOfBill);

    String getWayStatistic(String codeOfBill);

    boolean removeWayBillFromRepo(String numberOfWayBill);

    double sumOfAll();

    int getStatistics();



}
