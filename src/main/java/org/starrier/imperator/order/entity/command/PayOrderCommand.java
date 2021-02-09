package org.starrier.imperator.order.entity.command;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author starrier
 * @date 2021/1/10
 */
@Getter
@Setter
public class PayOrderCommand {

    @NotNull(message = "支付金额不能为空")
    private BigDecimal paidPrice;

}
