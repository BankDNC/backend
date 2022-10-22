package com.dnc.bank.models.request;

import com.dnc.bank.catalogs.TypeNit;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
public class UserRequest {
    @NotEmpty(message = "El nombre no puede ser vacío")
    private String name;
    @NotEmpty(message = "El apellido no puede ser vacío")
    private String lastName;
    @Email(message = "El correo electrónico no es válido")
    private String email;
    @Size(min = 8)
    private String password;
    @NotNull(message = "El tipo de NIT no puede ser vacío")
    private TypeNit typeNit;
    @NotEmpty(message = "El NIT no puede ser vacío")
    private String nit;
    @NotEmpty(message = "El teléfono no puede ser vacío")
    private String phone;
}
