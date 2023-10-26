package repostory;
import billOfLading.WayBill;
import java.util.Collection;


public interface Repostory {

    void addBillOfLading(WayBill wayBill);

    Collection<WayBill> getAllWaybills();
}
