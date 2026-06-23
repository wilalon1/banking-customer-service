package com.banking.customerservice.controller;

import com.banking.customerservice.model.Customer;
import com.banking.customerservice.service.CustomerService;


import io.reactivex.rxjava3.core.*;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public Mono<Customer> create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @GetMapping
    public Flux<Customer> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Customer> update(@PathVariable String id,
                                 @RequestBody Customer customer) {
        return service.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}