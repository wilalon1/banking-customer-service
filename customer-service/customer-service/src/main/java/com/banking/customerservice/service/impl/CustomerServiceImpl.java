package com.banking.customerservice.service.impl;

import com.banking.customerservice.client.CreditClient;
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


import com.banking.customerservice.model.Customer;
import com.banking.customerservice.repository.CustomerRepository;
import com.banking.customerservice.service.CustomerService;

import io.reactivex.rxjava3.core.*;

import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository repository;
    private final CreditClient creditClient;


    public CustomerServiceImpl(CustomerRepository repository,CreditClient creditClient){
        this.repository = repository;
        this.creditClient = creditClient;
    }



    /*@Override
    public Single<Customer> create(Customer customer){

        return Single.fromPublisher(
                repository.save(customer)
        );

    }*/
    @Override
    public Single<Customer> create(Customer customer){


        if(customer.getCustomerType()
                .equalsIgnoreCase("VIP")){


            return creditClient
                    .tieneTarjeta(customer.getId())


                    .flatMap(existe -> {


                        if(!existe){


                            return Single.error(
                                    new RuntimeException(
                                            "VIP customer needs credit card")
                            );

                        }


                        return Single.fromPublisher(
                                repository.save(customer)
                        );


                    });


        }


        return Single.fromPublisher(
                repository.save(customer)
        );

    }



    @Override
    public Observable<Customer> findAll(){

        return Observable.fromPublisher(
                repository.findAll()
        );

    }




    @Override
    public Single<Customer> findById(String id){

        return Single.fromPublisher(
                repository.findById(id)
        );

    }





    @Override
    public Observable<Customer> findByType(String type){

        return Observable.fromPublisher(
                repository.findByCustomerType(type)
        );

    }





    @Override
    public Single<Customer> update(String id, Customer customer){

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