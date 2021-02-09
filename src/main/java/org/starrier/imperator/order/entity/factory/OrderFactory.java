package org.starrier.imperator.order.entity.factory;

import org.springframework.stereotype.Component;
import org.starrier.imperator.order.entity.model.Address;
import org.starrier.imperator.order.entity.model.Order;
import org.starrier.imperator.order.entity.model.OrderItem;

import java.util.List;

/**
 * @author starrier
 * @date 2021/1/9
 */
@Component
public class OrderFactory {

    private final OrderIdGenerator idGenerator;

    public OrderFactory(OrderIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Order create(List<OrderItem> items, Address address) {
        String orderId = null;
        return Order.create(orderId, items, address);
    }

}
