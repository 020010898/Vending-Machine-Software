package com.acarasiov.vmsoft.model;

import java.math.BigDecimal;

public class Change {

    private int quarterCounter;
    private int dimeCounter;
    private int nickelCounter;
    private int pennyCounter;
    private BigDecimal cons;

    public Change(BigDecimal balance) {
        BigDecimal nothing = new BigDecimal("0");
        BigDecimal cons = new BigDecimal("100");

        BigDecimal quarter = new BigDecimal("25");
        BigDecimal dime = new BigDecimal("10");
        BigDecimal nickel = new BigDecimal("5");
        BigDecimal penny = new BigDecimal("1");

        BigDecimal changeBack = balance.multiply(cons);

        if (changeBack.compareTo(nothing) >= 0) {
            while (changeBack.compareTo(quarter) >= 0) {
                changeBack = changeBack.subtract(quarter);
                quarterCounter++;
            }
            while (changeBack.compareTo(dime) >= 0) {
                changeBack = changeBack.subtract(dime);
                dimeCounter++;
            }
            while (changeBack.compareTo(nickel) >= 0) {
                changeBack = changeBack.subtract(nickel);
                nickelCounter++;
            }
            while (changeBack.compareTo(penny) >= 0) {
                changeBack = changeBack.subtract(penny);
                pennyCounter++;
            }
        }
    }

    public int getQuarterCounter() {
        return quarterCounter;
    }

    public int getDimeCounter() {
        return dimeCounter;
    }

    public int getNickelCounter() {
        return nickelCounter;
    }

    public int getPennyCounter() {
        return pennyCounter;
    }

    public BigDecimal getCons() {
        return cons;
    }
}
