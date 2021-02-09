package org.starrier.imperator.order.repository;

import org.springframework.stereotype.Component;
import org.starrier.imperator.order.entity.model.Order;
import org.starrier.imperator.order.module.BaseRepository;

/**
 * @author starrier
 * @date 2021/1/10
 */
@Component
public class OrderRepository extends BaseRepository<Order> {

    public Order byId(String id) {
        return null;
    }

    @Override
    protected void doSave(Order aggregate) {

    }
}
