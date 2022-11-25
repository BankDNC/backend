package com.dnc.bank.services;

import com.dnc.bank.models.response.ProductResponse;

public interface ProductService {

    ProductResponse getProducts(String clientId);


}
