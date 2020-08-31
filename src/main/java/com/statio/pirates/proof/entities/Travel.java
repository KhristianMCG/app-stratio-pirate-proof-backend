package com.statio.pirates.proof.entities;

import com.statio.pirates.proof.enums.EventType;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
@Builder
@Value
public class Travel implements Serializable {

    private static final long serialVersionUID = 872040895277641796L;

    EventType eventType;
    Port port;
}
