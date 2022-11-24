package com.dnc.bank.models.documents;

import com.dnc.bank.catalogs.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Account {
    @Id
    private String id;
    private String number;
    private TypeAccount type;
    private Double balance;
    private String userId;
}
