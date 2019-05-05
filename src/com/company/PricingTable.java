package com.company;

import java.io.*;
import java.util.*;

/*
I'm modelling the tables as objects comprising lists of prices for each product and the totals, i.e. rows.
I could initialise both tables but I had a hard time forcing them to communicate with each other as they
would have separate copies of the prices.
In the end, I decided to use a txt file as a source of truth for Table A which will allow Table B to read
from to update itself.
 */


public class PricingTable {

    private double prod1Var1 = 10;
    private double prod1Var2 = 12;
    private double prod1Var3 = 14;
    private double prod1Var4 = 45;

    private double prod2Var1 = 20;
    private double prod2Var2 = 15;
    private double prod2Var3 = 24;

    private double prod3Var1 = 22;
    private double prod3Var2 = 60;

    private double prod4Var1 = 28;

    private double totVar1 = 80;
    private double totVar2 = 87;
    private double totVar3 = 38;
    private double totVar4 = 45;

    private LinkedList<Double> product1 = new LinkedList<>();
    private LinkedList<Double> product2 = new LinkedList<>();
    private LinkedList<Double> product3 = new LinkedList<>();
    private LinkedList<Double> product4 = new LinkedList<>();
    private LinkedList<Double> total = new LinkedList<>();

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

    private LinkedList<Double> getTotalPrices() {
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

    private void setTotal(double totvariety1,
                          double totvariety2,
                          double totvariety3,
                          double totvariety4) {
        LinkedList<Double> totals = new LinkedList<>();
        totals.add(0,totvariety1);
        totals.add(1,totvariety2);
        totals.add(2,totvariety3);
        totals.add(3,totvariety4);
        this.total = totals;
    }

    // When instantiating Table A provide starting values and write them to file
    public PricingTable() throws IOException {

        setupTableA();
    }

    // When instantiating Table B get the values from Table A and use the exchange rate.
    // It won't read the values from Table A from file yet.
    public PricingTable(PricingTable pricingTable) throws FileNotFoundException {

        setupTableB();
    }

    private void setupTableA() throws IOException{
        setProduct1(prod1Var1, prod1Var2, prod1Var3, prod1Var4);
        setProduct2(prod2Var1, prod2Var2, prod2Var3);
        setProduct3(prod3Var1, prod3Var2);
        setProduct4(prod4Var1);
        setTotal(totVar1, totVar2, totVar3, totVar4);

        writePricingTableAToFile();
    }

    private void setupTableB() throws FileNotFoundException {
        double exchangeRate = 1.5;

        setProduct1(prod1Var1 * exchangeRate, prod1Var2 * exchangeRate, prod1Var3 * exchangeRate, prod1Var4 * exchangeRate);
        setProduct2(prod2Var1 * exchangeRate, prod2Var2 * exchangeRate, prod2Var3 * exchangeRate);
        setProduct3(prod3Var1 * exchangeRate, prod3Var2 * exchangeRate);
        setProduct4(prod4Var1 * exchangeRate);
        setTotal(totVar1 * exchangeRate, totVar2 * exchangeRate, totVar3 * exchangeRate, totVar4 * exchangeRate);

        readCurrentPricingTableAFromFile();
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


    // TODO: I'm hardcoding the file location in Linux path format. Needs making it platform agnostic.
    private void writePricingTableAToFile() throws IOException
    {
        String product1Prices = getProduct1Prices().toString();
        String product2Prices = getProduct2Prices().toString();
        String product3Prices = getProduct3Prices().toString();
        String product4Prices = getProduct4Prices().toString();
        String totals = getTotalPrices().toString();

        BufferedWriter writer = new BufferedWriter(new FileWriter("./samplefile1.txt"));
        writer.write(product1Prices);
        writer.newLine();
        writer.write(product2Prices);
        writer.newLine();
        writer.write(product3Prices);
        writer.newLine();
        writer.write(product4Prices);
        writer.newLine();
        writer.write(totals);
        writer.close();
    }

    // TODO: Again needs making it platform agnostic.
    private List<String> readCurrentPricingTableAFromFile() throws FileNotFoundException {
        File file = new File("./samplefile1.txt");
        Scanner sc = new Scanner(file);
        List<String> currentPricingTableA = new ArrayList<String>();

        while (sc.hasNextLine()) {
            currentPricingTableA.add(sc.nextLine());
        }
        sc.close();

//        System.out.println(currentPricingTableA);

//        Iterator i = currentPricingTableA.iterator();
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }

        return currentPricingTableA;
    }

    public void updateProduct1TableA(double prod1variety1,
                                     double prod1variety2,
                                     double prod1variety3,
                                     double prod1variety4) throws IOException {


        setProduct1(prod1variety1,prod1variety2,prod1variety3,prod1variety4);

        writePricingTableAToFile();
    }

    // update Table B
    public void something() {

//        pricingTableB
    }

}
