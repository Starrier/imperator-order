package org.starrier.imperator.order.entity.command;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.starrier.imperator.order.entity.model.Address;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author starrier
 * @date 2021/1/14
 */
@Getter
@Setter
@Value
public class CreateOrderCommand {

    @Valid
    @NotEmpty(message = "订单项不能为空")
    List<OrderItemCommand> items;

    @NotNull(message = "订单地址不能为空")
    Address address;

}
