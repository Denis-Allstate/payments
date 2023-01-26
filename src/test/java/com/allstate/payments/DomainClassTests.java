package com.allstate.payments;

import com.allstate.payments.domain.Payment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DomainClassTests {

    @Test
    void test2PaymentsWithSameIdAreEqual(){
    Payment payment1 = new Payment();
        Payment payment2 = new Payment();
        payment1.setId(123);
        payment2.setId(123);
        assertEquals(payment1,payment2);
    }
}
