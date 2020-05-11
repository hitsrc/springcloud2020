package org.sample.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.sample.springcloud.entities.CommonResult;
import org.sample.springcloud.entities.Payment;
import org.sample.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/save")
    public CommonResult save(@RequestBody Payment payment) {

        int result = paymentService.save(payment);
        log.info("*****插入结果{}",result);
        if(result > 0) {
            return new CommonResult(200,String.format("插入成功,端口号：%s",serverPort),result);
        }else{
            return new CommonResult(444,String.format("插入失败,端口号：%s",serverPort));
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("*****结果{}",payment);
        if(payment != null) {
            return new CommonResult(200,String.format("查询成功,端口号：%s",serverPort),payment);
        }else{
            return new CommonResult(444,String.format("没有对应记录，id:%s 端口号:%s", id , serverPort));
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String el : services) {
            log.info("service:"+el);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance ins : instances) {

            String info = String.format("serviceid:%s, host:%s, port:%s, uri: %s", ins.getServiceId(), ins.getHost(), ins.getPort(), ins.getUri());
            log.info(info);
        }

        return this.discoveryClient;
    }

    @GetMapping(value="/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
