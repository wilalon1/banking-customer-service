package com.banking.customerservice.controller;

import com.banking.customerservice.model.Customer;
import com.banking.customerservice.service.CustomerService;


import io.reactivex.rxjava3.core.*;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {



    private final CustomerService service;



    public CustomerController(
            CustomerService service){

        this.service = service;

    }



    @PostMapping
    public Single<Customer> create(
            @RequestBody Customer customer){


        return service.create(customer);

    }




    @GetMapping
    public Observable<Customer> findAll(){


        return service.findAll();

    }




    @GetMapping("/{id}")
    public Maybe<Customer> findById(
            @PathVariable String id){


        return service.findById(id);

    }



    @PutMapping("/{id}")
    public Single<Customer> update(
            @PathVariable String id,
            @RequestBody Customer customer){


        return service.update(id,customer);

    }



    @DeleteMapping("/{id}")
    public Completable delete(
            @PathVariable String id){


        return service.delete(id);

    }


}