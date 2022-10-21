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
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    @Size(min = 8)
    private String password;
    @NotNull
    private TypeNit typeNit;
    @NotEmpty
    private String nit;
    @NotEmpty
    private String phone;
}
