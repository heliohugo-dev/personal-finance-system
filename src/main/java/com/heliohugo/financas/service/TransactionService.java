package com.heliohugo.financas.service;

import com.heliohugo.financas.model.Transaction;
import com.heliohugo.financas.model.TransactionType;
import com.heliohugo.financas.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionService {
    //ATRIBUTS
    private TransactionRepository repository;

    //CONSTRUCTOR
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    //METHODS
    public void register(Transaction transaction) {
        repository.insert(transaction);
    }

    public ArrayList<Transaction> searchByCategory(String category) {
        ArrayList<Transaction> searchResults = new ArrayList<>();

        for (Transaction transaction : getAll()) {
            if (transaction.getCategory().equalsIgnoreCase(category)) {
                searchResults.add(transaction);
            }
        }
        return searchResults;
    }

    public ArrayList<Transaction> getAll() {
        return repository.findAll();
    }

    public double calculateBalance() {
        ArrayList<Transaction> transactions = getAll();
        double balance = 0.0;

        for (Transaction transaction : transactions) { //for (TipoElemento apelido : ColecaoOuArray) { ... }
            if (transaction.getType() == TransactionType.REVENUE) {
                balance += transaction.getValue();
            } else {
                balance -= transaction.getValue();
            }
        }

        return balance;
    }
}
