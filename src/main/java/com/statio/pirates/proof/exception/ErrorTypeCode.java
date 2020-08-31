package com.statio.pirates.proof.exception;

public enum ErrorTypeCode implements ErrorType {

    PORT_NAME_NOT_FOUND("ERR-001", "Sorry Port name was not found"),

    SHIP_NAME_NOT_FOUND("ERR-002", "Sorry Ship name was not found");

    private final String code;
    private final String description;

    ErrorTypeCode(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getCode() {
        return this.code;
    }

}
