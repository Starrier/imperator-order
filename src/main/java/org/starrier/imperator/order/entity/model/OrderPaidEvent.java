package org.starrier.imperator.order.entity.model;

import java.beans.ConstructorProperties;

/**
 * @author starrier
 * @date 2021/1/14
 */
public class OrderPaidEvent extends OrderEvent {

    @ConstructorProperties({"orderId"})
    public OrderPaidEvent(String orderId) {
        super(orderId);
    }

}
