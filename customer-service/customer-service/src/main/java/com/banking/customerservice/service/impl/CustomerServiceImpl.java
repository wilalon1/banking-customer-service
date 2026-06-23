package com.banking.customerservice.service.impl;

import com.banking.customerservice.model.Customer;
import com.banking.customerservice.repository.CustomerRepository;
import com.banking.customerservice.service.CustomerService;


import io.reactivex.rxjava3.core.*;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Mono<Customer> create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Flux<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Customer> update(String id, Customer customer) {
        customer.setId(id);
        return repository.save(customer);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}