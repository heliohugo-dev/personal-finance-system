package com.heliohugo.financas.model;

import java.time.LocalDate;

public class Transaction {

    private long id;
    private TransactionType type;
    private double value;
    private LocalDate date;
    private String description;
    private String category;
    private boolean essential;

    public Transaction(
            long id, TransactionType type, double value,
            LocalDate date, String description, String category,
            boolean essential) {

        this.id = id;
        this.type = type;
        this.value = value;
        this.date = date;
        this.description = description;
        this.category = category;
        this.essential = essential;
    }

    //Getter and Setter -> ID
    public long getId () { return id; }
    public void setId(long id) {
        this.id = id;
    }

    //Getter and Setter -> TYPE (TransactionType)
    public TransactionType getType() {
        return type;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }

    //Getter and Setter -> VALUE
    public double getValue(){
        return value;
    }
    public void setValue(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        this.value = value; }

    //Getter and Setter -> LOCALDATE
    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    //Getter and Setter -> DESCRIPTION
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    //Getter and Setter -> CATEGORY
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    //Getter and Setter -> ESSENTIAL OR NO
    public boolean isEssential(){
        return essential;
    }
    public void setEssential(boolean essential){
        this.essential = essential;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type=" + type +
                ", value=R$" + String.format("%.2f", value) +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", essential=" + essential +
                '}';
    }
}
