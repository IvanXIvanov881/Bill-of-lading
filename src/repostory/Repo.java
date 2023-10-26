package repostory;
import billOfLading.WayBill;
import java.util.ArrayList;
import java.util.Collection;

public class Repo implements Repostory{

    private Collection<WayBill> wayBills;

    public Repo() {
        this.wayBills = new ArrayList<>();
    }

    @Override
    public void addBillOfLading(WayBill wayBill) {
        wayBills.add(wayBill);
    }

    @Override
    public void removeBillOfLading(WayBill wayBill) {
        wayBills.remove(wayBill);
    }

    @Override
    public Collection<WayBill> getAllWaybills() {
        return this.wayBills;
    }
}
