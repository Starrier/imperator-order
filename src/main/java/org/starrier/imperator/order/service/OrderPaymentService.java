package org.starrier.imperator.order.service;

import org.springframework.stereotype.Service;
import org.starrier.imperator.order.entity.model.Order;

import java.math.BigDecimal;

/**
 * @author starrier
 * @date 2021/1/11
 */
@Service
public class OrderPaymentService {

    private final OrderPaymentProxy paymentProxy;

    public OrderPaymentService(OrderPaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    public void pay(Order order, BigDecimal paidPrice) {
        order.pay(paidPrice);
        paymentProxy.pay(order.getId(), paidPrice);
    }
}
