package com.company;

import org.junit.Test;

import java.util.LinkedList;

import static com.company.PricingTable.updateTableA;
import static org.junit.Assert.assertEquals;

/*
Exercise: write a test to check the correctness of Table B in relation to Table A. Consideration should be given
to the variety of possible errors conditions within other real-world data, and how these can be tested. We are
not concerned solely with whether or not the test works, but also with how tidy, structured and robust it is.

Some scenarios are not covered because the way that I modelled the tables, for example;

- Updating variety price on Table A with a non-numerical character. Java expects a double so it won't allow it.
- Updating variety price on Table A with a null value. Same as above.

Find below the tests that I could devise for the Pricing Tables functionality.

 */

public class JUnitTests {

    @Test
    public void pricingTableAIsInitialisedCorrectly() {
        PricingTable pricingTableA = new PricingTable();
        String expectedTableAFromSetup =
                "[10.0, 12.0, 14.0, 45.0] " +
                "[20.0, 15.0, 24.0, null] " +
                "[22.0, 60.0, null, null] " +
                "[28.0, null, null, null] " +
                "[80.0, 87.0, 38.0, 45.0]";

        assertEquals(pricingTableA.toString(), expectedTableAFromSetup);
    }

    @Test
    public void pricingTableBIsInitialisedCorrectly() {
        PricingTable pricingTableA = new PricingTable();
        PricingTable pricingTableB = new PricingTable(pricingTableA);
        String expectedTableBFromSetup =
                "[15.0, 18.0, 21.0, 67.5] " +
                "[30.0, 22.5, 36.0, null] " +
                "[33.0, 90.0, null, null] " +
                "[42.0, null, null, null] " +
                "[120.0, 130.5, 57.0, 67.5]";

        assertEquals(pricingTableB.toString(), expectedTableBFromSetup);
    }

    @Test
    public void pricingTableBisUpdatedWithChangesToTableA() {
        PricingTable pricingTableA = new PricingTable();
        PricingTable pricingTableB = new PricingTable(pricingTableA);
        LinkedList<Double> newValues = new LinkedList<>();
        newValues.add(6.0);
        newValues.add(6.0);
        newValues.add(6.0);

        updateTableA(pricingTableA, pricingTableB, newValues);

//        System.out.println(pricingTableA);
//        System.out.println(pricingTableB);

        String expectedLatestTableBPrices =
                "[15.0, 18.0, 21.0, 67.5] " +
                "[9.0, 9.0, 9.0, null] " +
                "[33.0, 90.0, null, null] " +
                "[42.0, null, null, null] " +
                "[99.0, 117.0, 30.0, 67.5]";

        assertEquals(pricingTableB.toString(), expectedLatestTableBPrices);
    }

    @Test
    public void pricingTablesTotalsAreCalculatedCorrectly() {
        PricingTable pricingTableA = new PricingTable();
        PricingTable pricingTableB = new PricingTable(pricingTableA);

        LinkedList<Double> newValues = new LinkedList<>();
        newValues.add(6.0);
        newValues.add(6.0);
        newValues.add(6.0);
        newValues.add(6.0);

        updateTableA(pricingTableA, pricingTableB, newValues);

//        System.out.println(pricingTableA);
//        System.out.println(pricingTableB);

        String expectedTableATotals = "[66.0, 78.0, 20.0, 45.0]";
        String expectedTableBTotals = "[99.0, 117.0, 30.0, 67.5]";

        assertEquals(pricingTableA.getTotalPrices().toString(), expectedTableATotals);
        assertEquals(pricingTableB.getTotalPrices().toString(), expectedTableBTotals);
    }

    @Test
    public void updatingTableAWithTooManyPricesIgnoresExtraPrices() {
        PricingTable pricingTableA = new PricingTable();
        PricingTable pricingTableB = new PricingTable(pricingTableA);

        LinkedList<Double> newValues = new LinkedList<>();
        newValues.add(6.0);
        newValues.add(6.0);
        newValues.add(6.0);
        newValues.add(6.0);
        //The following additions to the list does not break the test
        newValues.add(111.0);
        newValues.add(111.0);

        updateTableA(pricingTableA, pricingTableB, newValues);

//        System.out.println(pricingTableA);
//        System.out.println(pricingTableB);

        String expectedTableBAfterTableAUpdatedWithTooManyValues =
                "[15.0, 18.0, 21.0, 67.5] " +
                "[9.0, 9.0, 9.0, null] " +
                "[33.0, 90.0, null, null] " +
                "[42.0, null, null, null] " +
                "[99.0, 117.0, 30.0, 67.5]";

        assertEquals(pricingTableB.toString(), expectedTableBAfterTableAUpdatedWithTooManyValues);
    }
}


