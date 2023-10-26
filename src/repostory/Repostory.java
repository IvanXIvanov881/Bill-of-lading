package repostory;
import billOfLading.WayBill;
import java.util.Collection;


public interface Repostory {

    void takeBillOfLading(WayBill wayBill);

    Collection<WayBill> getAllWaybills();
}
