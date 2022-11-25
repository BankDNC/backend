package com.dnc.bank.services.impl;

import com.dnc.bank.exceptions.NotFoundException;
import com.dnc.bank.models.response.ProductResponse;
import com.dnc.bank.repositories.UserRepository;
import com.dnc.bank.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private AccountServiceImpl accountService;
    private CardServiceImpl cardService;
    private UserRepository userRepository;

    @Override
    public ProductResponse getProducts(String clientId) {
        if (!userRepository.existsById(clientId)) {
            throw new NotFoundException("Client not found");
        }

        ProductResponse productResponse = new ProductResponse();
        productResponse.setAccounts(accountService.getAllAccountsByClientId(clientId));
        productResponse.setCards(cardService.getAllCardsByClientId(clientId));
        return productResponse;
    }
}
