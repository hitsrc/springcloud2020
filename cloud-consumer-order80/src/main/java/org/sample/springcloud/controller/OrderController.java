package org.sample.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.sample.springcloud.entities.CommonResult;
import org.sample.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value="/consumer/payment/save")
    public CommonResult<Payment> save(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save",payment,CommonResult.class);
    }


    @GetMapping(value="/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id ){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

}
