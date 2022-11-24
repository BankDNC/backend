package com.dnc.bank.catalogs;

public enum TypeCard {
    DEBIT("Tarjeta de Débito"),
    CREDIT("Tarjeta de Crédito");

    private String description;

    TypeCard(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
