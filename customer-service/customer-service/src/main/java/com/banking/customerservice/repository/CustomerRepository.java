package com.banking.customerservice.repository;

import com.banking.customerservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.banking.customerservice.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface CustomerRepository
        extends ReactiveMongoRepository<Customer,String> {


}