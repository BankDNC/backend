package com.dnc.bank.repositories;

import com.dnc.bank.models.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmail(String email);
    boolean existsByNit(String nit);

}
