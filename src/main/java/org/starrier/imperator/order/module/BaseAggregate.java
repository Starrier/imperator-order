package org.starrier.imperator.order.module;

import org.starrier.imperator.order.entity.DomainEvent;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author starrier
 * @date 2021/1/14
 */
public abstract class BaseAggregate {

    private List<DomainEvent> events;

    protected final void raiseEvent(DomainEvent event) {
        getEvents().add(event);
    }

    final void clearEvents() {
        getEvents().clear();
    }

    final List<DomainEvent> getEvents() {
        if (events == null) {
            events = newArrayList();
        }
        return events;
    }

}
