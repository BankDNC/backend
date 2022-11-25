package com.dnc.bank.repositories;

import com.dnc.bank.models.documents.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> findAllByUserId(String userId);

}
