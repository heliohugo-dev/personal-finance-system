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
}
