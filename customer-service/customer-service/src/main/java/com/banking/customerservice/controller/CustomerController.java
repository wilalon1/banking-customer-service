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
public class CustomerController {


    private final CustomerService service;


    public CustomerController(CustomerService service){
        this.service = service;
    }



    @GetMapping
    public Observable<Customer> findAll(){

        return service.findAll();

    }



    @PostMapping
    public Single<Customer> create(
            @RequestBody Customer customer){

        return service.create(customer);

    }



    @GetMapping("/{id}")
    public Single<Customer> findById(
            @PathVariable String id){

        return service.findById(id);

    }



    @DeleteMapping("/{id}")
    public Completable delete(
            @PathVariable String id){

        return service.delete(id);

    }

}