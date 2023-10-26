package repostory;

import billOfLading.WayBill;

import java.util.ArrayList;
import java.util.Collection;

import static common.ExceptionMessages.INCORRECT_NUMBER;

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
    public boolean removeLadingBill(int num) {
        for (WayBill wb: wayBills) {
            if (num == wb.getNumber()){
                wayBills.remove(wb);
                return true;
            }
        }
        return false;
    }

    @Override
    public WayBill getWayBill(int num) {
        for (WayBill wb: wayBills) {
            if (wb.getNumber() == num){
                return wb;
            }
        }
       throw new IllegalArgumentException(INCORRECT_NUMBER);
    }
}
