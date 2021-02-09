package org.starrier.imperator.order.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.starrier.imperator.order.entity.model.Order;

/**
 * @author starrier
 * @date 2021/2/9
 */
public interface ReactiveOrderMongoRepository extends ReactiveMongoRepository<Order, String>, ReactiveQuerydslPredicateExecutor<Order> {
}
