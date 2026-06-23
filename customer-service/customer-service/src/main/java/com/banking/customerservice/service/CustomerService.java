package com.banking.customerservice.service;

import com.banking.customerservice.model.Customer;
import io.reactivex.rxjava3.core.*;


public interface CustomerService {


    Single<Customer> create(Customer customer);


    Observable<Customer> findAll();


    Maybe<Customer> findById(String id);


    Single<Customer> update(
            String id,
            Customer customer
    );


    Completable delete(String id);

}