package org.sample.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.sample.springcloud.entities.CommonResult;
import org.sample.springcloud.entities.Payment;
import org.sample.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value="/payment/save")
    public CommonResult save(@RequestBody Payment payment) {

        int result = paymentService.save(payment);
        log.info("*****插入结果{}",result);
        if(result > 0) {
            return new CommonResult(200,"插入成功",result);
        }else{
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("*****结果{}",payment);
        if(payment != null) {
            return new CommonResult(200,"成功",payment);
        }else{
            return new CommonResult(444,String.format("没有对应记录，%s", id));
        }
    }
}
