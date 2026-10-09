package com.heliohugo.financas;

import com.heliohugo.financas.repository.TransactionRepository;
import com.heliohugo.financas.service.TransactionService;
import com.heliohugo.financas.ui.Menu;

public class Main {
    public static void main(String[] args) {

        TransactionRepository repository = new TransactionRepository();
        TransactionService transactionService = new TransactionService(repository);
        Menu menu = new Menu(transactionService);
        menu.start();
    }
}
