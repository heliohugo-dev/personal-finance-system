package com.heliohugo.financas.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.heliohugo.financas.model.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TransactionRepository {

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private File file = new File("transactions.json");
    private ObjectMapper mapper = new ObjectMapper();

    public TransactionRepository() {
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        loadFromFile();
    }

    public void insert(Transaction transaction) {
        transactions.add(transaction);
        saveToFile();
    }

    private void saveToFile() {
        try {
            mapper.writeValue(file, transactions);
        } catch (IOException e) {
            System.out.println("Error saving transactions to file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        if (file.exists()) {
            try {
                transactions = mapper.readValue(file, new TypeReference<ArrayList<Transaction>>() {
                });
            } catch (IOException e) {
                System.out.println("Error loading transactions from file: " + e.getMessage());
            }
        }
    }

    public ArrayList<Transaction> findAll() {
        return new ArrayList<Transaction>(transactions);
    }

    public Transaction findById(long id) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId() == id) {
                return transactions.get(i);
            }
        }
        return null;
    }

    public boolean update(Transaction transaction) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId() == transaction.getId()) {
                transactions.set(i, transaction);
                saveToFile();
                return true;
            }
        }
        return false;
    }
}
