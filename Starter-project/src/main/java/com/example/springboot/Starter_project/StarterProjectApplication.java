package com.example.springboot.Starter_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StarterProjectApplication.class, args);
	}

//    POJO object creation, this is tightly coupled, if later we have to make payment through another payment method, it will be require new object creation
//    private RazorpayPaymentService paymentService = new RazorpayPaymentService();

//    Adding autowired annotation is called field injection, this directly creates an object of the service
//    Less preferred when compared to constructor injection
//    @Autowired
    private RazorpayPaymentService razorpayPaymentService;
    private StripePaymentService stripePaymentService;

    private PaymentService paymentService;

//    Constructor injection most preferred way for object creation
//    All objects are stored in the container called as IOC container which is provided by Spring, and are managed by spring itself

    public StarterProjectApplication(PaymentService paymentService) {

//        This will again be tightly coupled as we need to specify which classes object needs to create
//        this.stripePaymentService = paymentService;

//        To implement loose coupling, we need to provide which object we want to create among razorpay or stripe service..
//        In this case, we will have to specify which class's object it needs to create otherwise it will give error for no of beans
//        Ways to specify which class's bean has to be created
//        - the primary annotation on the class for which we need to create bean
//        - ConditionalOnProperty annotation can be added where we can specify value of property in app.prop
//        - Pass that property in env variables
        this.paymentService = paymentService;

    }

    @Override
    public void run(String... args) throws Exception {
//        String response = stripePaymentService.pay();
        String response = paymentService.pay();
        System.out.println("Payment done: " + response);
    }
}
