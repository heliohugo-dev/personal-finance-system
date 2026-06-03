package com.heliohugo.financas.model;

import java.time.LocalDate;

public class Transacao {

    private long id;
    private TipoTransacao tipo;
    private double valor;
    private LocalDate data;
    private String descricao;
    private String categoria;
    private boolean essencial;

    public Transacao(
                     long id, TipoTransacao tipo, double valor,
                     LocalDate data, String descricao, String categoria,
                     boolean essencial) {

        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.essencial = essencial;
    }

    //Getter and Setter -> ID
    public long getId () { return id; }
    public void setId(long id) {
        this.id = id;
    }

    //Getter and Setter -> TIPO
    public TipoTransacao getTipo() {
        return tipo;
    }
    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    //Getter and Setter -> Valor
    public double getValor(){
        return valor;
    }
    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        this.valor = valor; }

    //Getter and Setter -> LOCALDATE
    public LocalDate getData (){
        return data;
    }
    public void setData (LocalDate data) {
        this.data = data;
    }

    //Getter and Setter -> DESCRIÇÃO
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    //Getter and Setter -> CATEGORIA
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    //Getter and Setter -> ESSENCIAL OU NÃO
    public boolean isEssencial(){
        return essencial;
    }
    public void setEssencial(boolean essencial){
        this.essencial = essencial;
    }

    @Override
    public String toString() {
        return "Transação{" +
                "id=" + id +
                ", tipo=" +
                ", valor=R$" + String.format("%.2f", valor) +
                ", data=" + data +
                ", descricao='" + descricao + '\'' + // Explicando ('\''): Observe que após o "=" da String "descricao" e "categoria"
                ", categoria='" + categoria + '\'' + // tem uma aspas simples ('). Isto serve apenas para estética do output. Porém temos
                ", essencial=" + essencial +         // que fechar o resultado da String que será impresso, por isso se usa o '\''.
                '}';                                 // Vejamos que (/') está dentro de aspas simples (''), o que significa que é um CHAR.
                                                     // Sendo assim, (/') é mesmo que uma aspas simples ('). Podemos dizer que (/') é um
                                                     // código para gerar uma aspas simples na espécie de um CHAR. Fechando o resultado das
                                                     // "descricao" e "categoria" com aspas simples, deixando o output mais organizado.
    }
}
