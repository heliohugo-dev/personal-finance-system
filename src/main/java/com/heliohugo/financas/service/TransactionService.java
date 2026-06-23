package com.heliohugo.financas.service;

import com.heliohugo.financas.model.Transaction;
import com.heliohugo.financas.model.TransactionType;
import com.heliohugo.financas.repository.TransactionRepository;

import java.util.ArrayList;

public class TransactionService {
    //ATRIBUTS
    private TransactionRepository repository;

    //CONSTRUCTOR
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    //METHODS
    //01
    public void register(Transaction transaction) {
        repository.insert(transaction);
    }

    //02
    public ArrayList<Transaction> getAll() {
        return repository.findAll();
    }

    //03
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
