package repostory;

import billOfLading.WayBill;

import java.util.List;

public interface Repostory {

    void addLadingBill(WayBill wayBill);

    boolean removeLadingBill(String codeToRemove);

    double getTotalVolume();

    double getTotalKilograms();

    List<WayBill> getAllWaybills();
}
