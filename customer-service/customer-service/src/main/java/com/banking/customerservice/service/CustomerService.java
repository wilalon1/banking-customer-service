package com.banking.customerservice.service;

import com.banking.customerservice.model.Customer;
import io.reactivex.rxjava3.core.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banking.customerservice.model.Customer;
import io.reactivex.rxjava3.core.*;

public interface CustomerService {

    Single<Customer> create(Customer customer);

    Observable<Customer> findAll();

    Single<Customer> findById(String id);

    Observable<Customer> findByType(String type);

    Single<Customer> update(String id, Customer customer);

    Completable delete(String id);

}