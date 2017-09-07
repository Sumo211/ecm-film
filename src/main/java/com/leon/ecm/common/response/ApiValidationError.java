package com.leon.ecm.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ApiSubError {

    private String object;

    private String field;

    private Object rejectedValue;

    private String message;

    public ApiValidationError(String objectName, String defaultMessage) {
        this.object = objectName;
        this.message = defaultMessage;
    }

}
