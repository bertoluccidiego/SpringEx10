package com.example.SpringEx10.controllers;

import com.example.SpringEx10.exceptions.NotEnoughMoneyException;
import com.example.SpringEx10.models.ErrorDetails;
import com.example.SpringEx10.models.PaymentDetails;
import com.example.SpringEx10.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();

            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException notEnoughMoneyException) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");

            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}
