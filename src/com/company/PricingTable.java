package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class PricingTable {

    private double exchangeRate = 1.5;

    private double prod1Var1 = 10;
    private double prod1Var2 = 12;
    private double prod1Var3 = 14;
    private double prod1Var4 = 45;

    private double prod2Var1 = 20;
    private double prod2Var2 = 15;
    private double prod2Var3 = 24;
    private double prod2Var4 = 24;

    private double prod3Var1 = 22;
    private double prod3Var2 = 60;
    private double prod3Var3 = 33;
    private double prod3Var4 = 34;

    private double prod4Var1 = 28;
    private double prod4Var2 = 42;
    private double prod4Var3 = 43;
    private double prod4Var4 = 44;

    private double totVar1 = 80;
    private double totVar2 = 87;
    private double totVar3 = 38;
    private double totVar4 = 45;

    private LinkedList product1 = new LinkedList();
    private LinkedList product2 = new LinkedList();
    private LinkedList product3 = new LinkedList();
    private LinkedList product4 = new LinkedList();
    private LinkedList total = new LinkedList();

    private LinkedList getProduct1Prices() {
        return this.product1;
    }

    private LinkedList getProduct2Prices() {
        return this.product2;
    }

    private LinkedList getProduct3Prices() {
        return this.product3;
    }

    private LinkedList getProduct4Prices() {
        return this.product4;
    }

    private LinkedList getTotalPrices() {
        return this.total;
    }

    private void setProduct1(double prod1variety1,
                             double prod1variety2,
                             double prod1variety3,
                             double prod1variety4) {
        LinkedList product = new LinkedList();
        product.add(0,prod1variety1);
        product.add(1,prod1variety2);
        product.add(2,prod1variety3);
        product.add(3,prod1variety4);
        this.product1 = product;
    }

    private void setProduct2(double prod2variety1,
                             double prod2variety2,
                             double prod2variety3,
                             double prod2variety4) {
        LinkedList product = new LinkedList();
        product.add(0,prod2variety1);
        product.add(1,prod2variety2);
        product.add(2,prod2variety3);
        product.add(3,null);
        this.product2 = product;
    }

    private void setProduct3(double prod3variety1,
                             double prod3variety2,
                             double prod3variety3,
                             double prod3variety4) {
        LinkedList product = new LinkedList();
        product.add(0,prod3variety1);
        product.add(1,prod3variety2);
        product.add(2,null);
        product.add(3,null);
        this.product3 = product;
    }

    private void setProduct4(double prod4variety1,
                             double prod4variety2,
                             double prod4variety3,
                             double prod4variety4) {
        LinkedList product = new LinkedList();
        product.add(0,prod4variety1);
        product.add(1,null);
        product.add(2,null);
        product.add(3,null);
        this.product4 = product;
    }

    private void setTotal(double totvariety1,
                             double totvariety2,
                             double totvariety3,
                             double totvariety4) {
        LinkedList totals = new LinkedList();
        totals.add(0,totvariety1);
        totals.add(1,totvariety2);
        totals.add(2,totvariety3);
        totals.add(3,totvariety4);
        this.total = totals;
    }


    public PricingTable() {

        setupTableA();
    }

    public PricingTable(PricingTable pricingTable) {

        setupTableB();
    }

    public void setupTableA() {
        setProduct1(prod1Var1, prod1Var2, prod1Var3, prod1Var4);
        setProduct2(prod2Var1, prod2Var2, prod2Var3, prod2Var4);
        setProduct3(prod3Var1, prod3Var2, prod3Var3, prod3Var4);
        setProduct4(prod4Var1, prod4Var2, prod4Var3, prod4Var4);
        setTotal(totVar1, totVar2, totVar3, totVar4);
    }

    private void setupTableB() {
        setProduct1(prod1Var1 *exchangeRate, prod1Var2*exchangeRate, prod1Var3*exchangeRate, prod1Var4*exchangeRate);
        setProduct2(prod2Var1 *exchangeRate, prod2Var2 *exchangeRate, prod2Var3 *exchangeRate, prod2Var4 *exchangeRate);
        setProduct3(prod3Var1 *exchangeRate, prod3Var2 *exchangeRate, prod3Var3 *exchangeRate, prod3Var4 *exchangeRate);
        setProduct4(prod4Var1 *exchangeRate, prod4Var2 *exchangeRate, prod4Var3 *exchangeRate, prod4Var4 *exchangeRate);
        setTotal(totVar1 *exchangeRate, totVar2 *exchangeRate, totVar3 *exchangeRate, totVar4 *exchangeRate);
    }

    @Override
    public String toString() {
        return getProduct1Prices() + " " +
                getProduct2Prices()  + " " +
                getProduct3Prices()  + " " +
                getProduct4Prices()  + " " +
                getTotalPrices();
    }







//        ArrayList <LinkedList> aList = new ArrayList<LinkedList>();
//        aList.add(product1);
//        aList.add(product2);
//        aList.add(product3);
//        aList.add(product4);
//        aList.add(total);
//
//        aList.set(0,total);
//
//        System.out.println(aList);


//    // model the object as an array of linked lists
//    public PricingTable() {
//
//        ArrayList <LinkedList> pricingTable = new ArrayList<LinkedList>();
//
//        product1.add(0,1);
//        product1.add(1,2);
//        product1.add(2,3);
//        product1.add(3,4);
//
//        product2.add(0,1);
//        product2.add(1,2);
//        product2.add(2,3);
//        product2.add(3,4);
//
//        product3.add(0,5);
//        product3.add(1,6);
//        product3.add(2,7);
//        product3.add(3,8);
//
//        product4.add(0,1);
//        product4.add(1,2);
//        product4.add(2,3);
//        product4.add(3,4);
//
//        total.add(0,1);
//        total.add(1,2);
//        total.add(2,3);
//        total.add(3,4);
//
//        pricingTable.add(product1);
//        pricingTable.add(product2);
//        pricingTable.add(product3);
//        pricingTable.add(product4);
//        pricingTable.add(total);
//
//    }


//
//
//    public void printTable(ArrayList <LinkedList> pricingTable) {
//
//        System.out.println(pricingTable.toString());
//
//        pricingTable.forEach(System.out::println);
//    }

//
//    /**
//     * Creates a row for the table
//     *
//     * @param productNumber
//     * @param variety1
//     * @param variety2
//     * @param variety3
//     * @param variety4
//     */
//
//    public LinkedList setVarietyPricesForProduct(int productNumber,
//                                                      int variety1,
//                                                      int variety2,
//                                                      int variety3,
//                                                      int variety4) {
//
//        LinkedList productPrices = new LinkedList();
//
//        switch (productNumber) {
//            case 1:
//                productPrices.add(0,variety1);
//                productPrices.add(1,variety2);
//                productPrices.add(2,variety3);
//                productPrices.add(3,variety4);
//        }
//
//
//        return productPrices;
//    }
//
//
//    private LinkedList setProductPrices(int prodvariety1, int prodvariety2, int prodvariety3, int prodvariety4) {
//
//        LinkedList productPrices = new LinkedList();
//
//        productPrices.add(0,prodvariety1);
//        productPrices.add(1,prodvariety2);
//        productPrices.add(2,prodvariety3);
//        productPrices.add(3,prodvariety4);
//
//        return productPrices;
//    }
//
//    private void updateTableB() {
//
//    }


//    public PricingTable() {
//
//
//        ArrayList <LinkedList> aList = new ArrayList<LinkedList>();
//        aList.add(product1);
//        aList.add(product2);
//        aList.add(product3);
//        aList.add(product4);
//        aList.add(total);
//    }



    // Create the rows
//    List<PricingTable> product1 = new ArrayList<PricingTable>();
//    List<PricingTable> product2 = new ArrayList<PricingTable>();
//    List<PricingTable> product3 = new ArrayList<PricingTable>();
//    List<PricingTable> product4 = new ArrayList<PricingTable>();
//    List<PricingTable> total = new ArrayList<PricingTable>();

    // add the data Product1
    //    product1.add(variety1)
    //    product1.add(variety2)
    //    product1.add(variety3)
    //    product1.add(variety4)
    // add data for other products and total

    // Derive table B
    // get values from (product1/variety1) * 1.5
}
