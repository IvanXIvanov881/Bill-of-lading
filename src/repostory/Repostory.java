package repostory;

import billOfLading.WayBill;

public interface Repostory {

    void addLadingBill(WayBill wayBill);

    boolean removeLadingBill(int num);

    WayBill getWayBill(int num);
}
