package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JUnitTests {

    // Table A is initialised from some hardcoded values so this should always pass.
    // It could only break in the table could not be created in the first place.
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


}


