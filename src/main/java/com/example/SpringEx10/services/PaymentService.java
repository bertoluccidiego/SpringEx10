package com.example.SpringEx10.services;

import com.example.SpringEx10.exceptions.NotEnoughMoneyException;
import com.example.SpringEx10.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
