package com.allstate.payments.service;

import com.allstate.payments.data.PaymentRepository;
import com.allstate.payments.domain.Payment;
import com.allstate.payments.exceptions.PaymentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Integer id) throws PaymentNotFoundException {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()){
            return optionalPayment.get();
        }else{
            throw new PaymentNotFoundException("There is no payment with id " +id);
        }
    }
    @Override
    public List<Payment> getByCountry(String country) {
        return paymentRepository.findAllByCountry(country);
    }

    @Override
    public List<Payment> getByOrderId(String orderId) {
        return paymentRepository.findAllByOrderId(orderId);
    }

    @Override
    public List<String> getAllCountries() {
        return paymentRepository.findAll().
        stream()
                .map(payment -> payment.getCountry().toLowerCase())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Payment savePayment(Payment payment) {
       return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Integer id, Map<String, Object> fields) {
        //load existing payment
       Payment payment = paymentRepository.findById(id).get();//should check and throw exception
        //update fields that changed
        if(fields.containsKey("country")){
            payment.setCountry(fields.get("country").toString());
        }
        if (fields.containsKey("amount")){
            //any logic here eg. amount >0
            payment.setAmount(Double.parseDouble(fields.get("amount").toString()));
        }

        return paymentRepository.save(payment);
    }
}
