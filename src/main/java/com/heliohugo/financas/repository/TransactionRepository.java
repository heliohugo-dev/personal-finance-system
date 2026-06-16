package com.heliohugo.financas.repository;

import com.heliohugo.financas.model.Transaction;

import java.util.ArrayList;

public class TransactionRepository {

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public void insert(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Transaction> findAll() {
        return new ArrayList<Transaction>(transactions);
    }

}
