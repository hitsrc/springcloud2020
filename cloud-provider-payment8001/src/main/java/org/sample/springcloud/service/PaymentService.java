package org.sample.springcloud.service;

import org.sample.springcloud.entities.Payment;

public interface PaymentService {

    public int save(Payment payment);

    public Payment getPaymentById(Long id);
}
