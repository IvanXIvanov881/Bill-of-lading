package core;

import billOfLading.WayBill;
import repostory.Repo;
import repostory.Repostory;

import java.util.List;

import static common.ExceptionMessages.INCORRECT_NUMBER;

public class Controller implements ControllerImp{

    private Repostory repostory;

    public Controller() {
        this.repostory = new Repo();
    }

    @Override
    public String addWayBillToRepo(WayBill wayBill) {
        repostory.addLadingBill(wayBill);
        return String.format("Uspeshno.\n");
    }

    @Override
    public String getWayBill(String codeOfBill) {
        for (WayBill wbNumber: repostory.getAllWaybills()) {
            if (wbNumber.getNumber().equals(codeOfBill)){
                return wbNumber.getStatistics();
            }
        }
        throw new IllegalArgumentException(INCORRECT_NUMBER);
    }

    @Override
    public int removeWayBillFromRepo(int numberOfWayBill) {
        return 0;
    }

    @Override
    public String getStatistics() {
        return null;
    }
}
