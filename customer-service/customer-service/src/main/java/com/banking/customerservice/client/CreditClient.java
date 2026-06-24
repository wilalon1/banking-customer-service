package com.banking.customerservice.client;

import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
@RequiredArgsConstructor
public class CreditClient {


    private final WebClient.Builder webClient;


    public Single<Boolean> tieneTarjeta(String customerId){


        return Single.fromPublisher(

                webClient.build()
                        .get()
                        .uri(
                                "http://CREDIT-SERVICE/api/credits/cards/customer/{id}",
                                customerId
                        )
                        .retrieve()
                        .bodyToMono(Boolean.class)

        );

    }

}