package repostory;
import billOfLading.WayBill;
import java.util.Collection;


public interface Repostory {

    void addLadingBill(WayBill wayBill);

    void removeLadingBill(WayBill wayBill);

    double getTotalVolume();

    double getTotalKilograms();

    Collection<WayBill> getAllWaybills();
}
