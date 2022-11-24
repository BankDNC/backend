package com.dnc.bank.catalogs;

public enum TypeAccount {
    CA("Cuenta de Ahorros"),
    CC("Cuenta Corriente");

    private String description;

    TypeAccount(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
