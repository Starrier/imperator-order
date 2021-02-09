package org.starrier.imperator.order.event;

import lombok.Getter;
import org.starrier.imperator.order.entity.model.Address;
import org.starrier.imperator.order.entity.model.OrderEvent;
import org.starrier.imperator.order.entity.model.OrderItem;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * @author starrier
 * @date 2021/1/19
 */
@Getter
public class OrderCreatedEvent extends OrderEvent {
    private BigDecimal price;
    private Address address;
    private List<OrderItem> items;
    private Instant createdAt;

    @ConstructorProperties({"orderId", "price", "address", "items", "createdAt"})
    public OrderCreatedEvent(String orderId, BigDecimal price, Address address, List<OrderItem> items, Instant createdAt) {
        super(orderId);
        this.price = price;
        this.address = address;
        this.items = items;
        this.createdAt = createdAt;
    }
}

