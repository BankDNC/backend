package com.dnc.bank.models.documents;

import com.dnc.bank.catalogs.TypeNit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private TypeNit typeNit;
    private String nit;
    private String phone;
}
