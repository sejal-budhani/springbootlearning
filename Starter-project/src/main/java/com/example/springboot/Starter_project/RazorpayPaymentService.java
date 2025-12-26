package com.example.springboot.Starter_project;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

// For Spring, to make the class available for creating an object, we need to add Component annotation as
// while running application it scans and finds which object it needs to create inside IOC
@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
public class RazorpayPaymentService implements PaymentService {
    public String pay() {
        String response = "Razorpay payment";
        System.out.println("Payment from: " + response);
        return response;
    }
}
