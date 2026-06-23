package com.banking.customerservice.service;

import com.banking.customerservice.model.Customer;
import io.reactivex.rxjava3.core.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CustomerService {

    Mono<Customer> create(Customer customer);

    Flux<Customer> findAll();

    Mono<Customer> findById(String id);

    Mono<Customer> update(String id, Customer customer);

    Mono<Void> delete(String id);
}