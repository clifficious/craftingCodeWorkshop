package com.pereira.workshop.craftingcode.exercise_04_mocking;

import com.pereira.workshop.craftingcode.exercise_04_mocking.model.PaymentDetails;
import com.pereira.workshop.craftingcode.exercise_04_mocking.model.User;
import org.springframework.stereotype.Service;

@Service
public interface FraudService {

    boolean isFraudulent(User user, PaymentDetails paymentDetails);
}
