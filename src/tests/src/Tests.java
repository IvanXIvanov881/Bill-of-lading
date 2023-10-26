package tests.src;

import billOfLading.FragileLoad;
import billOfLading.WayBill;
import core.Controller;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void testCreateFragileLoad(){
        WayBill wayBill = new FragileLoad("A123", 20, 30, "Dobrich", "Varna");
        Controller contr = new Controller();
        contr.addWayBillToRepo(wayBill);
        Assert.assertEquals(1, contr.getStatistics());
    }

    @Test
    public void testEmptyBlank(){

    }

    @Test
    public void testCreateBillOfLadingBlank(){

    }

    @Test
    public void testDifferentChoiceOfFragileAndUnbreakable(){

    }

    @Test
    public void testLettersInBlankForVolume(){

    }

    @Test
    public void testLettersInBlankForKilograms(){

    }

}
