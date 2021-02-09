package org.starrier.imperator.order.entity.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author starrier
 * @date 2021/1/13
 */
@Getter
@Builder
public class OrderItem {

    private String productId;
    private int count;
    private BigDecimal itemPrice;

    public OrderItem(String productId, int count) {
        this.productId = productId;
        this.count = count;
    }

    public OrderItem(String productId, int count, BigDecimal itemPrice) {
        this.productId = productId;
        this.count = count;
        this.itemPrice = itemPrice;
    }

    public static OrderItem create(String productId, int count, BigDecimal itemPrice) {
        return OrderItem.builder()
                .productId(productId)
                .count(count)
                .itemPrice(itemPrice)
                .build();
    }

    public BigDecimal totalPrice() {
        return itemPrice.multiply(BigDecimal.valueOf(count));
    }
}
