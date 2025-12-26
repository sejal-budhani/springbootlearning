package com.example.springboot.Starter_project;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "stripe")
public class StripePaymentService implements PaymentService {
    public String pay() {
        String response = "Stripe payment";
        System.out.println("Payment from: " + response);
        return response;
    }
}
