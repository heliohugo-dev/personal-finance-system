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
                ", description='" + description + '\'' + // Explicando ('\''): Observe que após o "=" da String "description" e "category"
                ", category='" + category + '\'' +       // tem uma aspas simples ('). Isto serve apenas para estética do output. Porém temos
                ", essential=" + essential +             // que fechar o resultado da String que será impresso, por isso se usa o '\''.
                '}';                                     // Vejamos que (/') está dentro de aspas simples (''), o que significa que é um CHAR.
                                                         // Sendo assim, (/') é mesmo que uma aspas simples ('). Podemos dizer que (/') é um
                                                         // código para gerar uma aspas simples na espécie de um CHAR. Fechando o resultado das
                                                         // "description" e "category" com aspas simples, deixando o output mais organizado.
    }
}
