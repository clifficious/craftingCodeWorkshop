package com.pereira.workshop.craftingcode.exercise_04_mocking;

import com.pereira.workshop.craftingcode.exercise_04_mocking.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public interface PaymentGateway {

    void executePayment(PaymentDetails paymentDetails);
}
