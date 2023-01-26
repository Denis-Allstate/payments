package com.allstate.payments.service;

import com.allstate.payments.domain.Payment;
import com.allstate.payments.exceptions.PaymentNotFoundException;

import java.util.List;
import java.util.Map;

public interface PaymentService {

    public List<Payment> getAllPayments();

    public Payment getById(Integer id) throws PaymentNotFoundException;

    public List<Payment> getByCountry(String country);

    public List<Payment> getByOrderId(String orderId);

    List<String> getAllCountries();

    public Payment savePayment(Payment payment);

    public Payment updatePayment(Integer id, Map<String, Object> fields);
}
