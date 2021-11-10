package com.pereira.workshop.craftingcode.exercise_04_mocking;

import com.pereira.workshop.craftingcode.exercise_04_mocking.exception.FraudulentPaymentException;
import com.pereira.workshop.craftingcode.exercise_04_mocking.model.PaymentDetails;
import com.pereira.workshop.craftingcode.exercise_04_mocking.model.User;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final FraudService fraudService;
    private final PaymentGateway paymentGateway;

    public PaymentService(FraudService fraudService, PaymentGateway paymentGateway) {
        this.fraudService = fraudService;
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(User user, PaymentDetails paymentDetails) {
        if (fraudService.isFraudulent(user, paymentDetails)) {
            throw new FraudulentPaymentException();
        }
        paymentGateway.executePayment(paymentDetails);
    }
}
