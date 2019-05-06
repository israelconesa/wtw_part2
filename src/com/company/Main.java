package com.company;

import java.util.LinkedList;

import static com.company.PricingTable.updateTableA;


public class Main {

    public static void main(String[] args) {

        PricingTable pricingTableA = new PricingTable();
        PricingTable pricingTableB = new PricingTable(pricingTableA);

        System.out.println(pricingTableA);
        System.out.println(pricingTableB);

        LinkedList<Double> newValues = new LinkedList<>();
        newValues.add(6.0);
        newValues.add(6.0);
        newValues.add(6.0);
        newValues.add(6.0);

        updateTableA(pricingTableA, pricingTableB, newValues);

        System.out.println(pricingTableA);
        System.out.println(pricingTableB);

        LinkedList<Double> newValues2 = new LinkedList<>();
        newValues2.add(2.0);
        newValues2.add(2.0);
        newValues2.add(2.0);
        newValues2.add(2.0);

        updateTableA(pricingTableA, pricingTableB, newValues2);

        System.out.println(pricingTableA);
        System.out.println(pricingTableB);

    }
}
