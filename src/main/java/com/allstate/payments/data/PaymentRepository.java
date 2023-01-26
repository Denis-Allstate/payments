package com.allstate.payments.data;

import com.allstate.payments.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    public List<Payment> findAllByCountry(String country);

    public List<Payment> findAllByOrderId(String orderId);
}
