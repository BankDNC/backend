package com.dnc.bank.catalogs;

public enum TypeNit {
    CC("Cedula de Ciudadania"),
    TI("Tarjeta de Identidad"),
    TE("Tarjeta de extranjeria");
    private String name;

    TypeNit(String name){
        this.name = name;
    }
}
