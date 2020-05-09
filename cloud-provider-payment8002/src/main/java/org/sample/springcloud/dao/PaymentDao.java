package org.sample.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sample.springcloud.entities.Payment;
import org.springframework.stereotype.Repository;

@Mapper
// @Repository 推荐用上面的
public interface PaymentDao {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}