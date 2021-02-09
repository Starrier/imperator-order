package org.starrier.imperator.order.exception;

import static com.google.common.collect.ImmutableMap.of;
import static org.starrier.imperator.order.entity.model.OrderErrorCode.PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE;

/**
 * @author starrier
 * @date 2021/1/11
 */
public class PaidPriceNotSameWithOrderPriceException extends AppException {

    public PaidPriceNotSameWithOrderPriceException(String id) {
        super(PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE, of("orderId", id));
    }

}
