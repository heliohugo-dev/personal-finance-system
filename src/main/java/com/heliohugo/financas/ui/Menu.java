package com.heliohugo.financas.ui;

import com.heliohugo.financas.model.Transaction;
import com.heliohugo.financas.model.TransactionType;
import com.heliohugo.financas.service.TransactionService;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    private TransactionService service;
    private Scanner scanner;

    public Menu(TransactionService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int options = -1;

        do {
            // Print menu
            System.out.println("=== Financial System ===");
            System.out.println("1. Register transaction");
            System.out.println("2. List all transactions");
            System.out.println("3. Show balance");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            options = scanner.nextInt();
            scanner.nextLine();
            if (options == 1) {
                //Record transaction
                // -------- ID --------
                System.out.print("ID: ");
                long id = scanner.nextLong();

                // -------- Type --------
                System.out.println("Type: ");
                System.out.println("1. Revenue");
                System.out.println("2. Expense");
                System.out.print("Choose: ");
                int typeChoice = scanner.nextInt();

                TransactionType type = typeChoice == 1 ? TransactionType.REVENUE : TransactionType.EXPENSE;
                // -------- Value --------
                System.out.print("Value: ");
                double value = scanner.nextDouble();
                scanner.nextLine();

                // -------- Date --------
                // YEAR
                System.out.print("Year: ");
                int year = scanner.nextInt();
                // MONTH
                System.out.print("Month (1-12): ");
                int month = scanner.nextInt();
                // DAY
                System.out.println("Day: ");
                int day = scanner.nextInt();
                scanner.nextLine();
                LocalDate date = LocalDate.of(year, month, day);

                // -------- Description --------
                System.out.print("Description: ");
                String description = scanner.nextLine();

                // -------- Category --------
                System.out.print("Category: ");
                String category = scanner.nextLine();

                // -------- essential --------
                System.out.println("Essential?");
                System.out.println("1. YES");
                System.out.println("2. NO");
                System.out.println("Choose: ");
                int essentialChoice = scanner.nextInt();
                boolean essential = essentialChoice == 1;

                // -------- Transaction Object --------
                Transaction transaction = new Transaction(id, type, value, date, description, category, essential);
                service.register(transaction);
                System.out.println("Transaction registered successfully!");

            } else if (options == 2) {
                // List transactions
                for (Transaction transaction : service.getAll()) {
                    System.out.println(transaction);
                }

            } else if (options == 3) {
                // Show balance
                double balance = service.calculateBalance();
                System.out.println(String.format("Balance: R$%.2f", balance));
            }

        } while (options != 0);
    }


}
