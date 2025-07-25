package com.teleport.logistics.tracking.exception;

import java.io.Serial;

public class TNGCustomException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 4893003346574492302L;

    private final ErrorMessage errorMessage;

    public TNGCustomException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return this.errorMessage;
    }

}
