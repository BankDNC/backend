package com.dnc.bank.repositories;

import com.dnc.bank.models.documents.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardRepository extends MongoRepository<Card, String> {

    List<Card> findAllByUserId(String userId);

}
