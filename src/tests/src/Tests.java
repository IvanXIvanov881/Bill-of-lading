package tests.src;
import billOfLading.FragileLoad;
import billOfLading.WayBill;
import core.ControllerImp;
import org.junit.Assert;
import org.junit.Test;


public class Tests {

    @Test
    public void testCreateFragileLoad(){
        ControllerImp controllerImp = new ControllerImp();
        WayBill wayBill = new FragileLoad("A123", 20, 30, "Dobrich", "Varna");
        controllerImp.addWayBillToRepo(wayBill);
        Assert.assertEquals(1, controllerImp.getStatistics());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeVolume(){
        ControllerImp controllerImp = new ControllerImp();
        WayBill wayBill = new FragileLoad("A123", 20, -30, "Dobrich", "Varna");
        controllerImp.addWayBillToRepo(wayBill);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNegativeKilograms(){
        ControllerImp controllerImp = new ControllerImp();
        WayBill wayBill = new FragileLoad("A123", -20, 30, "Dobrich", "Varna");
        controllerImp.addWayBillToRepo(wayBill);
    }

    @Test
    public void testRemoveBlank(){
        ControllerImp controllerImp = new ControllerImp();
        WayBill wayBill = new FragileLoad("A123", 20, 30, "Dobrich", "Varna");
        controllerImp.addWayBillToRepo(wayBill);
        controllerImp.removeWayBillToRepo("A123");
        Assert.assertEquals(0, controllerImp.getStatistics());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNotExistingBillOfLading(){
        ControllerImp controllerImp = new ControllerImp();
        WayBill wayBill = new FragileLoad("A123", 20, 30, "Dobrich", "Varna");
        controllerImp.addWayBillToRepo(wayBill);
        controllerImp.getWayStatistic("DDD");
    }
}
