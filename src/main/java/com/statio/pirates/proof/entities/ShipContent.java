package com.statio.pirates.proof.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
@Builder
@Value
public class ShipContent implements Serializable {

    private static final long serialVersionUID = -3250861399972961833L;

    int barrelsOfRum;
    int goldCoins;
}
