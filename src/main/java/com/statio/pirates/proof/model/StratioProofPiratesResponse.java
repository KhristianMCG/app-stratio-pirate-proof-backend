package com.statio.pirates.proof.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.statio.pirates.proof.entities.Travel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        creatorVisibility = JsonAutoDetect.Visibility.ANY
)
public class StratioProofPiratesResponse implements Serializable {

    private static final long serialVersionUID = -6847380843218177810L;

    List<Travel> allTravels;
    Map<String, Integer> stocks;
}
