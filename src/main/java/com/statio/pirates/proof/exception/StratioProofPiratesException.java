package com.statio.pirates.proof.exception;

public class StratioProofPiratesException extends RuntimeException {
    private static final long serialVersionUID = -3234041003872052598L;

    private final ErrorType type;

    public StratioProofPiratesException(final ErrorType errorType) {
        super(errorType.getDescription());
        this.type = errorType;
    }

    public StratioProofPiratesException(final ErrorType errorType, final Throwable exception) {
        super(errorType.getDescription(), exception);
        this.type = errorType;
    }

    public String getErrorId() {
        return this.type.getCode();
    }

    public ErrorType getType() {
        return this.type;
    }
}
