package org.starrier.imperator.order.entity.model;

import lombok.Value;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * @author starrier
 * @date 2021/1/14
 */
@Value
public class OrderRepresentation {

    private String id;

    private List<OrderItem> items;

    private BigDecimal totalPrice;

    private String status;

    private Address address;

    private Instant createdAt;
}
