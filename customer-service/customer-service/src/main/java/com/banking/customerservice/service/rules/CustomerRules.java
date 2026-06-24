package com.banking.customerservice.service.rules;


import com.banking.customerservice.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerRules {


    public void validate(Customer customer){


        validateProfile(customer);


    }



    private void validateProfile(Customer customer){


        if(customer.getProfile()
                .equals("VIP")){


            if(!customer.getCustomerType()
                    .equals("PERSONAL")){


                throw new RuntimeException(
                        "VIP only allowed PERSONAL");


            }


        }



        if(customer.getProfile()
                .equals("PYME")){


            if(!customer.getCustomerType()
                    .equals("EMPRESARIAL")){


                throw new RuntimeException(
                        "PYME only allowed EMPRESARIAL");


            }


        }


    }

}