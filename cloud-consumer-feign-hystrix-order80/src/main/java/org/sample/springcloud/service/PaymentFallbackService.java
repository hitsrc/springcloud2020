package org.sample.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 客户端针对服务提供方接口 服务降级处理
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--------  paymentInfo_OK fallback";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-------- paymentInfo_TimeOut fallback";
    }
}
