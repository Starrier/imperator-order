package org.starrier.imperator.order.exception;

/**
 * @author starrier
 * @date 2021/1/14
 */
public interface ErrorCode {

    int getStatus();

    String getMessage();

    String getCode();
}
