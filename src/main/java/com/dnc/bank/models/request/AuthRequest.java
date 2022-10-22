package com.dnc.bank.models.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class AuthRequest {
    @Email(message = "El correo electrónico no es válido")
    private String email;
    @NotEmpty(message = "La contraseña no puede ser vacía")
    private String password;
}
