package com.company;

import java.util.*;

public class PricingTable {

    private static double exchangeRate = 1.5;

    private LinkedList<Double> product1;
    private LinkedList<Double> product2;
    private LinkedList<Double> product3;
    private LinkedList<Double> product4;
    private LinkedList<Double> total;

    private LinkedList<Double> getProduct1Prices() {
        return this.product1;
    }

    private LinkedList<Double> getProduct2Prices() {
        return this.product2;
    }

    private LinkedList<Double> getProduct3Prices() {
        return this.product3;
    }

    private LinkedList<Double> getProduct4Prices() {
        return this.product4;
    }

    public LinkedList<Double> getTotalPrices() {
        return this.total;
    }

    private void setProduct1(double prod1variety1,
                             double prod1variety2,
                             double prod1variety3,
                             double prod1variety4) {
        LinkedList<Double> product = new LinkedList<>();
        product.add(0,prod1variety1);
        product.add(1,prod1variety2);
        product.add(2,prod1variety3);
        product.add(3,prod1variety4);
        this.product1 = product;
    }

    // The setters from this point on will be having less parameters
    // as the shaded areas in the tables will be set to null
    private void setProduct2(double prod2variety1,
                             double prod2variety2,
                             double prod2variety3) {
        LinkedList<Double> product = new LinkedList<>();
        product.add(0,prod2variety1);
        product.add(1,prod2variety2);
        product.add(2,prod2variety3);
        product.add(3,null);
        this.product2 = product;
    }

    private void setProduct3(double prod3variety1,
                             double prod3variety2) {
        LinkedList<Double> product = new LinkedList<>();
        product.add(0,prod3variety1);
        product.add(1,prod3variety2);
        product.add(2,null);
        product.add(3,null);
        this.product3 = product;
    }

    private void setProduct4(double prod4variety1) {
        LinkedList<Double> product = new LinkedList<>();
        product.add(0,prod4variety1);
        product.add(1,null);
        product.add(2,null);
        product.add(3,null);
        this.product4 = product;
    }

    // Calculating the totals for each variety
    private void setTotal() {
        LinkedList<Double> totals = new LinkedList<>();
        totals.add(0,product1.get(0) + product2.get(0) + product3.get(0) + product4.get(0));
        totals.add(1,product1.get(1) + product2.get(1) + product3.get(1));
        totals.add(2,product1.get(2) + product2.get(2));
        totals.add(3, product1.get(3));
        this.total = totals;
    }

    // This is the constructor for Table A initialised with the prices from the example.
    PricingTable() {

        double prod1Var1 = 10;
        double prod1Var2 = 12;
        double prod1Var3 = 14;
        double prod1Var4 = 45;

        double prod2Var1 = 20;
        double prod2Var2 = 15;
        double prod2Var3 = 24;

        double prod3Var1 = 22;
        double prod3Var2 = 60;

        double prod4Var1 = 28;

        setProduct1(prod1Var1, prod1Var2, prod1Var3, prod1Var4);
        setProduct2(prod2Var1, prod2Var2, prod2Var3);
        setProduct3(prod3Var1, prod3Var2);
        setProduct4(prod4Var1);
        setTotal();
    }

    // This is the constructor for Table B and takes a PricingTable object as a parameter (Table A, at runtime).
    // It will read the initial prices from Table A and add them to Table B with the exchange rates.
    PricingTable(PricingTable pricingTable) {

        setProduct1(pricingTable.getProduct1Prices().get(0) * exchangeRate,
                    pricingTable.getProduct1Prices().get(1) * exchangeRate,
                    pricingTable.getProduct1Prices().get(2) * exchangeRate,
                    pricingTable.getProduct1Prices().get(3) * exchangeRate);

        setProduct2(pricingTable.getProduct2Prices().get(0) * exchangeRate,
                    pricingTable.getProduct2Prices().get(1) * exchangeRate,
                    pricingTable.getProduct2Prices().get(2) * exchangeRate);

        setProduct3(pricingTable.getProduct3Prices().get(0) * exchangeRate,
                    pricingTable.getProduct3Prices().get(1) * exchangeRate);

        setProduct4(pricingTable.getProduct4Prices().get(0) * exchangeRate);
        setTotal();
    }

    // For simplicity, updates are done by the same row (product2 prices). If needed it could be deconstructed
    // further to change a single price for any product.
    static void updateTableA(PricingTable tableA, PricingTable tableB, LinkedList<Double> newPriceListForProduct2) {

        // Protecting against negative and 0 values. It will throw an exception and leave TableA/B unchanged.
        if (newPriceListForProduct2.get(0) <= 0 ||
                newPriceListForProduct2.get(1) <= 0 ||
                    newPriceListForProduct2.get(2) <= 0) {
            String msg = "Unable to update prices to less or equal 0. Leaving Pricing Tables unchanged...";
            System.out.println(msg);
            throw new IllegalArgumentException(msg);

        } else {

            tableA.setProduct2(newPriceListForProduct2.get(0),
                    newPriceListForProduct2.get(1),
                    newPriceListForProduct2.get(2));
            tableA.setTotal();

            tableB.setProduct2(tableA.getProduct2Prices().get(0) * exchangeRate,
                    tableA.getProduct2Prices().get(1) * exchangeRate,
                    tableA.getProduct2Prices().get(2) * exchangeRate);
            tableB.setTotal();
        }
    }

    // Overriding this implementation so I get a proper view of the table rows
    @Override
    public String toString() {
        return getProduct1Prices() + " " +
                getProduct2Prices()  + " " +
                getProduct3Prices()  + " " +
                getProduct4Prices()  + " " +
                getTotalPrices();
    }
}
