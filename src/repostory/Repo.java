package repostory;

import billOfLading.WayBill;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Repo implements Repostory{

    private Collection<WayBill> wayBills;

    public Repo() {
        this.wayBills = new ArrayList<>();
    }

    @Override
    public void addLadingBill(WayBill wayBill) {
        wayBills.add(wayBill);
    }

    @Override
    public boolean removeLadingBill(String codeToRemove) {
        for (WayBill wb: wayBills) {
            if (codeToRemove.equals(wb.getNumber())){
                wayBills.remove(wb);
                return true;
            }
        }
        return false;
    }


    @Override
    public double getTotalVolume() {
        double totalVolume = 0;
        for (WayBill wbVolume: wayBills) {
            totalVolume+=wbVolume.getVolume();
        }
        return totalVolume;
    }

    @Override
    public double getTotalKilograms() {
        double totalKilograms = 0;
        for (WayBill wbKilograms: wayBills) {
            totalKilograms+=wbKilograms.getKilograms();
        }
        return totalKilograms;
    }

    @Override
    public List<WayBill> getAllWaybills() {
        List<WayBill> wbl = new ArrayList<>();
        wbl.addAll(wayBills);
        return wbl;
    }
}
