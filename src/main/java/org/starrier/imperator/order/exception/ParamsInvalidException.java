package org.starrier.imperator.order.exception;

import static com.google.common.collect.ImmutableMap.of;
import static org.starrier.imperator.order.entity.model.ParamsErrorCode.PARAMS_NON_BLANK;

/**
 * @author starrier
 * @date 2021/1/18
 */
public class ParamsInvalidException extends AppException {

    public ParamsInvalidException(String params) {

        super(PARAMS_NON_BLANK, of("params", params));
    }
}
