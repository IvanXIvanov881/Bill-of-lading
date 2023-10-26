package core;

import billOfLading.WayBill;

public interface ControllerImp {


    String addWayBillToRepo(WayBill wayBill);

    String getWayBill(String codeOfBill);

    int removeWayBillFromRepo(int numberOfWayBill);

    String getStatistics();


}
