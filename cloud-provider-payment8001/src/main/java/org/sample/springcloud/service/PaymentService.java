package org.sample.springcloud.service;

import org.sample.springcloud.entities.Payment;

public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(Long id);
}
