package com.fishmarket.salerestapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fishmarket.salerestapi.models.Sale;

@Repository
public interface SaleRepository extends MongoRepository<Sale, String> {

}
