package org.starrier.imperator.order.repository;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

/**
 * @author starrier
 * @date 2021/2/3
 */
public interface ReactiveOrderRepository extends ReactiveSortingRepository<OrderDO,String> {


}
