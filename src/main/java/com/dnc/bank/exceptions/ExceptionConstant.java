package com.dnc.bank.exceptions;

public class ExceptionConstant {

    private ExceptionConstant() {
        throw new IllegalStateException("Utility class");
    }
    public static final String INVALID_CREDENTIALS = "Credenciales invalidas";
    public static final String USER_NOT_FOUND = "Usuario no encontrado";
    public static final String EMAIL_EXIST = "El correo ya se encuentra registrado";
    public static final String NIT_EXIST = "El nit ya se encuentra registrado";
}
