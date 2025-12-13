package com.bitspilani.leadmanager.model;

public class Transaction {

    private final double amount;
    private final TransactionType type;

    public Transaction(double amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}