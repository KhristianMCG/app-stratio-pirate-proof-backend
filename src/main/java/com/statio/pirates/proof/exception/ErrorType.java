package com.statio.pirates.proof.exception;

import java.io.Serializable;

public interface ErrorType extends Serializable {

    String getDescription();

    String getCode();
}
