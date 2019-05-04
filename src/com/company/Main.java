package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PricingTable pricingTableA = new PricingTable();
        PricingTable pricingTableB = new PricingTable(pricingTableA);

//        pricingTableA.setVarietyPricesForProduct(1,1,2,3,4);

//        LinkedList whatever = new LinkedList();
//        whatever.add(0,61);
//        whatever.add(1,62);
//        whatever.add(2,63);
//        whatever.add(3,64);
//
//        pricingTableA.setProduct4(whatever);

        System.out.println(pricingTableA);
        System.out.println(pricingTableB);
    }
}
