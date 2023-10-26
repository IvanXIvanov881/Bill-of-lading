package priceCalculator;
import core.Controller;
import repostory.Repo;

public class PriceCalculator implements Calculator {
    private Controller controller;

    public PriceCalculator() {
        controller = new Controller();
    }

    @Override
    public double sumOfAll() {
       return 0;
    }
}
