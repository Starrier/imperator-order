package org.starrier.imperator.order.module;

import org.springframework.stereotype.Repository;
import org.starrier.imperator.order.entity.DomainEventDao;
import org.starrier.imperator.order.module.BaseAggregate;



/**
 * @author starrier
 * @date 2021/1/14
 */
@Repository
public abstract class BaseRepository<AR extends BaseAggregate> {


    private DomainEventDao eventDao;

    public final void save(AR aggregate) {
        eventDao.save(aggregate.getEvents());
        aggregate.clearEvents();
        doSave(aggregate);
    }

    protected abstract void doSave(AR aggregate);
}
