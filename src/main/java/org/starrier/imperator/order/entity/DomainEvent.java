package org.starrier.imperator.order.entity;

import java.time.Instant;

import static java.time.Instant.now;

/**
 * @author starrier
 * @date 2021/1/14
 */
public abstract class DomainEvent {

    private String id = null;

    private Instant createdAt = now();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + id + "]";
    }

}
