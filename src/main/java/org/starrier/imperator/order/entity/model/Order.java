package org.starrier.imperator.order.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.starrier.imperator.order.event.OrderCreatedEvent;
import org.starrier.imperator.order.exception.PaidPriceNotSameWithOrderPriceException;
import org.starrier.imperator.order.module.BaseAggregate;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ZERO;
import static java.time.Instant.now;
import static org.starrier.imperator.order.entity.model.OrderStatus.CREATED;
import static org.starrier.imperator.order.entity.model.OrderStatus.PAID;

/**
 * @author starrier
 * @date 2021/1/9
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseAggregate {

    private String id;

    private List<OrderItem> items;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private Address address;
    private Instant createdAt;

    public static Order create(String id, List<OrderItem> items, Address address) {
        Order order = Order.builder()
                .id(id)
                .items(items)
                .totalPrice(calculateTotalPrice(items))
                .status(CREATED)
                .address(address)
                .createdAt(now())
                .build();
        order.raiseCreatedEvent(id, items, address);
        return order;
    }

    private static BigDecimal calculateTotalPrice(List<OrderItem> items) {
        return items.stream()
                .map(OrderItem::totalPrice)
                .reduce(ZERO, BigDecimal::add);
    }

    private void raiseCreatedEvent(String id, List<OrderItem> items, Address address) {
        List<OrderItem> orderItems = items.stream()
                .map(orderItem -> new OrderItem(orderItem.getProductId(),
                        orderItem.getCount())).collect(Collectors.toList());
        raiseEvent(new OrderCreatedEvent(id, totalPrice, address, orderItems, createdAt));
    }

    public void pay(BigDecimal paidPrice) {

        if (!this.totalPrice.equals(paidPrice)) {
            throw new PaidPriceNotSameWithOrderPriceException(id);
        }
        this.status = PAID;
        raiseEvent(new OrderPaidEvent(this.getId()));

    }


    public OrderRepresentation toRepresentation() {
        var itemRepresentations = this.getItems().stream()
                .map(orderItem -> new OrderItem(orderItem.getProductId(),
                        orderItem.getCount(),
                        orderItem.getItemPrice()))
                .collect(Collectors.toList());

        return new OrderRepresentation(this.getId(),
                itemRepresentations,
                this.getTotalPrice(),
                this.getStatus().name(),
                this.getAddress(),
                this.getCreatedAt());


    }

    public Mono<OrderRepresentation> toReactiveRepresentation() {
        var itemRepresentations = this.getItems().stream()
                .map(orderItem -> new OrderItem(orderItem.getProductId(),
                        orderItem.getCount(),
                        orderItem.getItemPrice()))
                .collect(Collectors.toList());

        OrderRepresentation orderRepresentation = new OrderRepresentation(this.getId(),
                itemRepresentations,
                this.getTotalPrice(),
                this.getStatus().name(),
                this.getAddress(),
                this.getCreatedAt());

        return Mono.just(orderRepresentation);

    }


}
