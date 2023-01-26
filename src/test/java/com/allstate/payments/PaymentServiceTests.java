package com.allstate.payments;

import com.allstate.payments.data.PaymentRepository;
import com.allstate.payments.data.UserRepository;
import com.allstate.payments.domain.Payment;
import com.allstate.payments.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class PaymentServiceTests {

    @Autowired
    private PaymentService paymentService;

    @MockBean
    private PaymentRepository paymentRepository;

    @MockBean
    private UserRepository userRepository;
    @Test
    void testGetAllCountries(){
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment(null, 0d, "gbr", "GBP", new Date(System.currentTimeMillis()), "",0, 0d, ""));
        payments.add(new Payment(null, 0d, "irl", "GBP", new Date(System.currentTimeMillis()), "",0, 0d, ""));
        payments.add(new Payment(null, 0d, "fra", "GBP", new Date(System.currentTimeMillis()), "",0, 0d, ""));
        payments.add(new Payment(null, 0d, "GBR", "GBP", new Date(System.currentTimeMillis()), "",0, 0d, ""));
        payments.add(new Payment(null, 0d, "nld", "GBP", new Date(System.currentTimeMillis()), "",0, 0d, ""));
        Mockito.when(paymentRepository.findAll()).thenReturn(payments);

        List<String> countries = paymentService.getAllCountries();
        assertEquals(4, countries.size());
    }
}
