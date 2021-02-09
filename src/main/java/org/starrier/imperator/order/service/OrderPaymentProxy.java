package org.starrier.imperator.order.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author starrier
 * @date 2021/1/11
 */
@Component
public class OrderPaymentProxy {

    public void pay(String orderId, BigDecimal paidPrice) {
        //call remote payment service
    }

}
