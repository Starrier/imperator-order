package org.starrier.imperator.order.entity.model;

import org.starrier.imperator.order.entity.DomainEvent;

/**
 * @author starrier
 * @date 2021/1/14
 */
public abstract class OrderEvent extends DomainEvent {

    private String orderId;

    protected OrderEvent(String orderId) {
        this.orderId = orderId;
    }
}
