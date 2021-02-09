package org.starrier.imperator.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starrier.common.utils.json.FastJsonUtils;
import org.starrier.common.utils.json.JacksonUtils;
import org.starrier.imperator.order.config.ReactiveRedisConfig;
import org.starrier.imperator.order.entity.model.Order;
import org.starrier.imperator.order.entity.model.OrderRepresentation;
import org.starrier.imperator.order.repository.OrderDO;
import org.starrier.imperator.order.repository.OrderRepository;
import org.starrier.imperator.order.repository.ReactiveOrderRepository;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author starrier
 * @date 2021/1/9
 */
@Service
@RequiredArgsConstructor
public class OrderRepresentationService {

    private final OrderRepository orderRepository;

    private final ReactiveRedisOperations<String, String> reactiveRedisOperations;

    private final ReactiveOrderRepository reactiveOrderRepository;

    @Transactional(readOnly = true)
    public Mono<OrderRepresentation> byId(String id) {
        // 1. 先查缓存
        var orderMono = reactiveRedisOperations.opsForValue()
                .get(id)
                .flatMap(OrderRepresentationService::convert)
                .block();
        // 2. 缓存不存在则查询 数据库
        if(Objects.nonNull(orderMono)){
            return orderMono.toReactiveRepresentation();
        }
        Order order = orderRepository.byId(id);
        return order.toReactiveRepresentation();
    }

    @Transactional(readOnly = true)
    public void findById(String orderId){
        Mono<OrderDO> byId = reactiveOrderRepository.findById(orderId);
    }

    private static Mono<Order> convert(String jsonResult){
       return JacksonUtils.toReactiveJavaObject(jsonResult,Order.class);
    }
}
