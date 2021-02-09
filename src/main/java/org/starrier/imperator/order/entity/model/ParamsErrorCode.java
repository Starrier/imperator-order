package org.starrier.imperator.order.entity.model;

import org.starrier.imperator.order.exception.ErrorCode;

/**
 * @author starrier
 * @date 2021/1/18
 */
public enum ParamsErrorCode implements ErrorCode {

    PARAMS_NON_BLANK(1, "参数不可为空");

    private int status;

    private String message;

    ParamsErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
