package com.banking.customerservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;

    private String name;
    private String documentNumber;
    private String type; // PERSONAL / BUSINESS
}