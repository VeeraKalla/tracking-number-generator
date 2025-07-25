package com.teleport.logistics.tracking.exception;

/**
 * Immutable class to store the exception message and error code
 */
public final class ErrorMessage {

    private final ErrorCode code;
    private final String message;

    public ErrorMessage(ErrorCode code) {
        this(code, code.getDefaultMessage());
    }

    public ErrorMessage(ErrorCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code.getValue();
    }

    @Override
    public String toString() {
        return "ErrorMessage {" +
                "code=" + getCode() +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
