package com.company;

public class Main {

    public static void main(String[] args) {

        PricingTable pricingTableA = new PricingTable();
        PricingTable pricingTableB = new PricingTable(pricingTableA);

        System.out.println(pricingTableA);
        System.out.println(pricingTableB);


    }
}
