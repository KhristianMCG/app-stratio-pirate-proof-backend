package com.statio.pirates.proof.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
@Builder
@Value
public class Ship implements Serializable {

    private static final long serialVersionUID = -2238371820791722846L;

    String shipName;
    ShipContent shipContent;
}
