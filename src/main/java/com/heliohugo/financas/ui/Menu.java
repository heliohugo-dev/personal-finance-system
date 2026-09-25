package com.heliohugo.financas.ui;

import com.heliohugo.financas.model.Transaction;
import com.heliohugo.financas.model.TransactionType;
import com.heliohugo.financas.service.TransactionService;

import java.time.DateTimeException;
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
                    // PRINT MENU
                System.out.println("=== Financial System ===");
                System.out.println("1. Register transaction");
                System.out.println("2. List all transactions");
                System.out.println("3. Show balance");
                System.out.println("0. Exit");
                System.out.println("================");
                options = readInt("Choose an option: ");
                System.out.println("================");
                    //RECORD TRANSACTION
                if (options == 1) {
                    // -------- ID --------
                    long id = readLong("ID: ");
                    System.out.println("................");

                    // -------- Type --------
                    System.out.println("Type: ");
                    System.out.println("1. Revenue");
                    System.out.println("2. Expense");
                    int typeChoice = readInt("Choose: ");
                    System.out.println("................");

                    TransactionType type = typeChoice == 1 ? TransactionType.REVENUE : TransactionType.EXPENSE;
                    // -------- Value --------
                    double value = readDouble("Value: ");
                    System.out.println("................");

                    // -------- Date --------
                    LocalDate date = readDate("Transaction date:");
                    System.out.println("................");

                    // -------- Description --------
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.println("................");

                    // -------- Category --------
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.println("................");

                    // -------- essential --------
                    System.out.println("Essential?");
                    System.out.println("1. YES");
                    System.out.println("2. NO");
                    int essentialChoice = readInt("Choose: ");
                    boolean essential = essentialChoice == 1;
                    System.out.println("................");

                    // -------- Transaction Object --------
                    Transaction transaction = new Transaction(id, type, value, date, description, category, essential);
                    service.register(transaction);
                    System.out.println("Transaction registered successfully!");

                    // LIST TRANSACTIONS
                } else if (options == 2) {
                    for (Transaction transaction : service.getAll()) {
                        System.out.println(transaction);
                    }

                    // SHOW BALANCE
                } else if (options == 3) {
                    double balance = service.calculateBalance();
                    System.out.println(String.format("Balance: R$%.2f", balance));
                }
        } while (options != 0);
    }

                    //INPUT READING/VALIDATION METHODS

    private int readInt(String message) {
        System.out.print(message);
            while(!scanner.hasNextInt()) {
                System.out.println("Invalid number. Try again: ");
                scanner.next();
            }
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
    }

    private long readLong(String message) {
        System.out.print(message);
            while(!scanner.hasNextLong()) {
                System.out.println("Invalid number. Try again: ");
                scanner.next();
            }
            long id = scanner.nextLong();
            scanner.nextLine();
            return id;
    }

    private double readDouble(String message) {
        System.out.print(message);
            while(!scanner.hasNextDouble()) {
                System.out.println("Invalid number. Try again: ");
                scanner.next();
            }
            double value = scanner.nextDouble();
            scanner.nextLine();
            return value;
    }

    private LocalDate readDate(String message) {
        System.out.println(message);
            while(true) {
                int year = readInt("Year: ");
                int month = readInt("Month: ");
                int day = readInt("Day: ");

            try {
                LocalDate date = LocalDate.of(year, month, day);
                return date;
            } catch (DateTimeException e) {
                System.out.println("Invalid date. Try again.");
            }
            }

    }
}
