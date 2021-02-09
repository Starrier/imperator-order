package org.starrier.imperator.order.entity;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author starrier
 * @date 2021/1/14
 */
@Component
public interface DomainEventDao {

    void save(List<DomainEvent> events);

    void delete(String eventId);

    DomainEvent get(String eventId);

    List<DomainEvent> nextPublishBatch(int size);

    void markAsPublished(String eventId);

    void markAsPublishFailed(String eventId);

    void deleteAll();
}
