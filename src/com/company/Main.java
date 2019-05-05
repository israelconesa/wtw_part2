package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        PricingTable pricingTableA = new PricingTable();
        PricingTable pricingTableB = new PricingTable(pricingTableA);

        System.out.println(pricingTableA);
        System.out.println(pricingTableB);

        pricingTableA.updateProduct1TableA(1,1,1,1);
    }
}
