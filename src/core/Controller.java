package core;
import billOfLading.WayBill;
import repostory.Repo;
import repostory.Repostory;

import static common.ExceptionMessages.INCORRECT_NUMBER;

public class Controller implements ControllerImp {

    private Repostory repostory;

    public Controller() {
        this.repostory = new Repo();
    }

    @Override
    public void addWayBillToRepo(WayBill wayBill) {
        repostory.addBillOfLading(wayBill);
    }

    @Override
    public boolean removeWayBillToRepo(String codeOfWayBill) {
        for (WayBill wb : repostory.getAllWaybills()) {
            if (wb.getNumber().equals(codeOfWayBill)) {
                repostory.removeBillOfLading(wb);
                return true;
            }
        }
        return false;
    }

    @Override
    public WayBill getWayBill(String codeOfBill) {
        for (WayBill wbNumber : repostory.getAllWaybills()) {
            if (wbNumber.getNumber().equals(codeOfBill)) {
                return wbNumber;
            }
        }
        throw new IllegalArgumentException(INCORRECT_NUMBER);
    }

    public String getWayStatistic(String codeOfBill) {
        for (WayBill wbNumber : repostory.getAllWaybills()) {
            if (wbNumber.getNumber().equals(codeOfBill)) {
                return wbNumber.getStatistics();
            }
        }
        throw new IllegalArgumentException(INCORRECT_NUMBER);
    }

    @Override
    public boolean removeWayBillFromRepo(String numberOfWayBill) {
        for (WayBill wb : repostory.getAllWaybills()) {
            if (numberOfWayBill.equals(wb.getNumber())) {
                repostory.getAllWaybills().remove(wb);
                return true;
            }
        }
        return false;
    }

    @Override
    public double sumOfAll() {
        double total = 0;

        for (WayBill wbToSum: repostory.getAllWaybills()) {

            total+= (wbToSum.getKilograms() + wbToSum.getVolume()) * wbToSum.getPriceIndex();
        }

        return total;
    }

    @Override
    public int getStatistics() {
        return repostory.getAllWaybills().size();
    }
}
