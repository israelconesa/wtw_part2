package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class PricingTable {

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

    private void setProduct1(int prod1variety1,
                             int prod1variety2,
                             int prod1variety3,
                             int prod1variety4) {
        LinkedList product = new LinkedList();
        product.add(0,prod1variety1);
        product.add(1,prod1variety2);
        product.add(2,prod1variety3);
        product.add(3,prod1variety4);
        this.product1 = product;
    }

    private void setProduct2(int prod2variety1,
                             int prod2variety2,
                             int prod2variety3,
                             int prod2variety4) {
        LinkedList product = new LinkedList();
        product.add(0,prod2variety1);
        product.add(1,prod2variety2);
        product.add(2,prod2variety3);
        product.add(3,prod2variety4);
        this.product2 = product;
    }

    private void setProduct3(int prod3variety1,
                             int prod3variety2,
                             int prod3variety3,
                             int prod3variety4) {
        LinkedList product = new LinkedList();
        product.add(0,prod3variety1);
        product.add(1,prod3variety2);
        product.add(2,prod3variety3);
        product.add(3,prod3variety4);
        this.product3 = product;
    }

    private void setProduct4(int prod4variety1,
                             int prod4variety2,
                             int prod4variety3,
                             int prod4variety4) {
        LinkedList product = new LinkedList();
        product.add(0,prod4variety1);
        product.add(1,prod4variety2);
        product.add(2,prod4variety3);
        product.add(3,prod4variety4);
        this.product4 = product;
    }

    private void setTotal(int totvariety1,
                             int totvariety2,
                             int totvariety3,
                             int totvariety4) {
        LinkedList totals = new LinkedList();
        totals.add(0,totvariety1);
        totals.add(1,totvariety2);
        totals.add(2,totvariety3);
        totals.add(3,totvariety4);
        this.total = totals;
    }

    private int prod1variety1 = 11;
    private int prod1variety2 = 12;
    private int prod1variety3 = 13;
    private int prod1variety4 = 14;


    private int prod2variety1 = 21;
    private int prod2variety2 = 22;
    private int prod2variety3 = 23;
    private int prod2variety4 = 24;

    private int prod3variety1 = 31;
    private int prod3variety2 = 32;
    private int prod3variety3 = 33;
    private int prod3variety4 = 34;

    private int prod4variety1 = 41;
    private int prod4variety2 = 42;
    private int prod4variety3 = 43;
    private int prod4variety4 = 44;

    private int totvariety1 = 91;
    private int totvariety2 = 92;
    private int totvariety3 = 93;
    private int totvariety4 = 94;


    public PricingTable() {

        ArrayList <LinkedList> pricingTable = new ArrayList<LinkedList>();

        setupTableA();
    }

    private void setupTableA() {
        setProduct1(prod1variety1, prod1variety2, prod1variety3, prod1variety4);
        setProduct2(prod2variety1, prod2variety2, prod2variety3, prod2variety4);
        setProduct3(prod3variety1, prod3variety2, prod3variety3, prod3variety4);
        setProduct4(prod4variety1, prod4variety2, prod4variety3, prod4variety4);
        setTotal(totvariety1, totvariety2, totvariety3, totvariety4);
    }



















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

    @Override
    public String toString() {
        return product1 + " " + product2 + " " + product3 + " " + product4 + " " + total;
    }


    public void printTable(ArrayList <LinkedList> pricingTable) {

        System.out.println(pricingTable.toString());

        pricingTable.forEach(System.out::println);
    }


    /**
     * Creates a row for the table
     *
     * @param productNumber
     * @param variety1
     * @param variety2
     * @param variety3
     * @param variety4
     */

    public LinkedList setVarietyPricesForProduct(int productNumber,
                                                      int variety1,
                                                      int variety2,
                                                      int variety3,
                                                      int variety4) {

        LinkedList productPrices = new LinkedList();

        switch (productNumber) {
            case 1:
                productPrices.add(0,variety1);
                productPrices.add(1,variety2);
                productPrices.add(2,variety3);
                productPrices.add(3,variety4);
        }


        return productPrices;
    }


    private LinkedList setProductPrices(int prodvariety1, int prodvariety2, int prodvariety3, int prodvariety4) {

        LinkedList productPrices = new LinkedList();

        productPrices.add(0,prodvariety1);
        productPrices.add(1,prodvariety2);
        productPrices.add(2,prodvariety3);
        productPrices.add(3,prodvariety4);

        return productPrices;
    }

    private void updateTableB() {

    }


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
