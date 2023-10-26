package core;

import repostory.Repostory;

public class Controller implements ControllerImp{

    private Repostory repostory;

    public Controller(Repostory repostory) {
        this.repostory = repostory;
    }

    @Override
    public String addWayBillToRepo(int numberOfWayBill, double kilograms, String currentLocation, String toLocation) {
        return null;
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
