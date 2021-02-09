package org.starrier.imperator.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starrier.imperator.order.entity.command.CreateOrderCommand;
import org.starrier.imperator.order.entity.command.PayOrderCommand;
import org.starrier.imperator.order.entity.factory.OrderFactory;
import org.starrier.imperator.order.entity.model.Order;
import org.starrier.imperator.order.entity.model.OrderItem;
import org.starrier.imperator.order.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author starrier
 * @date 2021/1/9
 */
@Slf4j
@Service
public class OrderApplicationService {


    private final OrderRepository orderRepository;
    private final OrderPaymentService orderPaymentService;
    private final OrderFactory orderFactory;

    public OrderApplicationService(OrderRepository orderRepository, OrderPaymentService orderPaymentService, OrderFactory orderFactory) {
        this.orderRepository = orderRepository;
        this.orderPaymentService = orderPaymentService;
        this.orderFactory = orderFactory;
    }

    @Transactional(rollbackFor = Exception.class)
    public void pay(String id, PayOrderCommand command) {
        Order order = orderRepository.byId(id);
        orderPaymentService.pay(order, command.getPaidPrice());
        orderRepository.save(order);
    }

    @Transactional
    public String createOrder(CreateOrderCommand command) {
        List<OrderItem> items = command.getItems().stream()
                .map(item -> OrderItem.create(item.getProductId(),
                        item.getCount(),
                        item.getItemPrice()))
                .collect(Collectors.toList());

        Order order = orderFactory.create(items, command.getAddress());
        orderRepository.save(order);
        log.info("Created order[{}].", order.getId());
        return order.getId();
    }

}
