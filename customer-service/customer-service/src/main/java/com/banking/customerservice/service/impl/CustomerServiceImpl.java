package com.banking.customerservice.service.impl;

import com.banking.customerservice.model.Customer;
import com.banking.customerservice.repository.CustomerRepository;
import com.banking.customerservice.service.CustomerService;


import io.reactivex.rxjava3.core.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl
        implements CustomerService {



    private final CustomerRepository repository;



    private static final Logger log =
            LoggerFactory.getLogger(CustomerServiceImpl.class);



    public CustomerServiceImpl(
            CustomerRepository repository){

        this.repository = repository;
    }



    @Override
    public Single<Customer> create(Customer customer){


        log.info(
                "Creating customer {}",
                customer.getDocumentNumber()
        );


        return Single.fromPublisher(
                repository.save(customer)
        );

    }



    @Override
    public Observable<Customer> findAll(){


        log.info(
                "Finding all customers"
        );


        return Observable.fromPublisher(
                repository.findAll()
        );

    }



    @Override
    public Maybe<Customer> findById(String id){


        return Maybe.fromPublisher(
                repository.findById(id)
        );

    }



    @Override
    public Single<Customer> update(
            String id,
            Customer customer){


        customer.setId(id);


        return Single.fromPublisher(
                repository.save(customer)
        );

    }



    @Override
    public Completable delete(String id){


        return Completable.fromPublisher(
                repository.deleteById(id)
        );

    }


}