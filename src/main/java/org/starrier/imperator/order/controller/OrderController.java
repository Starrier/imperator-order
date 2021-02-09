package org.starrier.imperator.order.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.starrier.common.result.ReactiveResult;
import org.starrier.common.result.Result;
import org.starrier.imperator.order.config.ReactiveRedisConfig;
import org.starrier.imperator.order.entity.command.CreateOrderCommand;
import org.starrier.imperator.order.entity.command.PayOrderCommand;
import org.starrier.imperator.order.entity.model.OrderRepresentation;
import org.starrier.imperator.order.service.OrderApplicationService;
import org.starrier.imperator.order.service.OrderRepresentationService;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author starrier
 * @date 2021/1/9
 */
@RestController
@RequestMapping("api/v1/order")
public class OrderController {


    private final OrderApplicationService applicationService;

    private final OrderRepresentationService representationService;

    public OrderController(OrderApplicationService applicationService, OrderRepresentationService representationService) {
        this.applicationService = applicationService;
        this.representationService = representationService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<ReactiveResult> createOrder(@RequestBody @Valid CreateOrderCommand command) {

        return ReactiveResult.success(applicationService.createOrder(command));
    }


    @PostMapping("/pay")
    public void pay(@RequestBody @Valid PayOrderCommand payOrderCommand) {
        applicationService.pay("", payOrderCommand);
    }

    @GetMapping("/{id}")
    public Mono<ReactiveResult> details(@PathVariable("id")String id){
        return ReactiveResult.success(representationService.byId(id));

    }

    @GetMapping("/{userId}")
    public Mono<ReactiveResult> findUserById(@PathVariable String userId) {
        return null;
       // return reactiveClientUserSortingRepository.findById(userId);
    }

}
