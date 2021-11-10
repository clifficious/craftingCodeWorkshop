package com.pereira.workshop.craftingcode.exercise_04_mocking;

import com.pereira.workshop.craftingcode.exercise_04_mocking.exception.FraudulentPaymentException;
import com.pereira.workshop.craftingcode.exercise_04_mocking.model.PaymentDetails;
import com.pereira.workshop.craftingcode.exercise_04_mocking.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    private static final User USER = new User();
    private static final PaymentDetails PAYMENT_DETAILS = new PaymentDetails();

    @Mock
    FraudService fraudService;
    @Mock
    PaymentGateway paymentGateway;

    @InjectMocks
    PaymentService paymentService;

    @Test
    void throws_Exception_when_payment_is_fraudulent() {
        given(fraudService.isFraudulent(USER, PAYMENT_DETAILS)).willReturn(true);

        assertThatExceptionOfType(FraudulentPaymentException.class).isThrownBy(() -> paymentService.processPayment(USER, PAYMENT_DETAILS));
        verify(fraudService).isFraudulent(USER, PAYMENT_DETAILS);
    }

    @Test
    void has_no_interaction_with_payment_gateway_when_fraudulent_payment() {
        given(fraudService.isFraudulent(USER, PAYMENT_DETAILS)).willReturn(true);

        assertThatExceptionOfType(FraudulentPaymentException.class).isThrownBy(() -> paymentService.processPayment(USER, PAYMENT_DETAILS));
        verifyNoInteractions(paymentGateway);
    }

    @Test
    void executes_payment_when_no_fraud_detected() {
        given(fraudService.isFraudulent(USER, PAYMENT_DETAILS)).willReturn(false);

        paymentService.processPayment(USER, PAYMENT_DETAILS);
        verify(paymentGateway).executePayment(PAYMENT_DETAILS);
    }
}