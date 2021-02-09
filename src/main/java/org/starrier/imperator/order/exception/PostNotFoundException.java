package org.starrier.imperator.order.exception;

/**
 * @author starrier
 * @date 2021/2/8
 */
public class PostNotFoundException extends RuntimeException {
    PostNotFoundException(String id) {
        super("Post:" + id + " is not found.");
    }
}