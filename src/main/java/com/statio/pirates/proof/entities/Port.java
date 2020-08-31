package com.statio.pirates.proof.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
@Builder
@Value
public class Port implements Serializable {

    private static final long serialVersionUID = 4408423940688418714L;

    String portName;
    Ship ship;
}
