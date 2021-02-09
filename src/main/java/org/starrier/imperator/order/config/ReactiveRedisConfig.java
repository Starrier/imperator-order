package org.starrier.imperator.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.starrier.imperator.order.entity.model.Order;

/**
 * @author starrier
 * @date 2021/2/8
 */
@Configuration
public class ReactiveRedisConfig {

    /**
     * customer Jackson2JsonRedisSerializer value type
     *
     * @param factory
     * @return
     */
    @Bean
    ReactiveRedisOperations<String, Order> redisOperations(ReactiveRedisConnectionFactory factory) {

        Jackson2JsonRedisSerializer<Order> serializer = new Jackson2JsonRedisSerializer<>(Order.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, Order> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, Order> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);

    }

}
