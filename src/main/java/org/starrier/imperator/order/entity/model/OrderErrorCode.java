package org.starrier.imperator.order.entity.model;

import org.starrier.imperator.order.exception.ErrorCode;

/**
 * @author starrier
 * @date 2021/1/14
 */
public enum OrderErrorCode implements ErrorCode {

    ORDER_CANNOT_BE_MODIFIED(1, "订单无法变更"),
    ORDER_NOT_FOUND(2, "没有找到订单"),
    PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE(3, "支付价格与订单实际价格不符"),
    PRODUCT_NOT_IN_ORDER(4, "订单不包含产品");

    private int status;

    private String message;

    OrderErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }


    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
