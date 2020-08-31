package com.statio.pirates.proof.repository;

import com.statio.pirates.proof.entities.Port;
import com.statio.pirates.proof.entities.Ship;
import com.statio.pirates.proof.entities.ShipContent;
import com.statio.pirates.proof.entities.Travel;
import com.statio.pirates.proof.enums.EventType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This repository is simulating returning data travel set collection.
 */
public class StratioProofPiratesRepository {

    private static final List<Travel> dataTravels = new ArrayList<>();

    static {

        final Travel travelOne = Travel.builder()
                .eventType(EventType.ARRIVAL)
                .port(Port.builder()
                        .portName("Pirate+Bay+Port")
                        .ship(Ship.builder()
                                .shipName("Pirateer")
                                .shipContent(ShipContent.builder()
                                        .barrelsOfRum(100)
                                        .goldCoins(100)
                                        .build())
                                .build())
                        .build())
                .build();

        final Travel travelTwo = Travel.builder()
                .eventType(EventType.DEPARTURE)
                .port(Port.builder()
                        .portName("Bahia+Occident")
                        .ship(Ship.builder()
                                .shipName("Oceans")
                                .shipContent(ShipContent.builder()
                                        .barrelsOfRum(345)
                                        .goldCoins(500)
                                        .build())
                                .build())
                        .build())
                .build();

        final Travel travelThree = Travel.builder()
                .eventType(EventType.DEPARTURE)
                .port(Port.builder()
                        .portName("Seychells+Lost+Port")
                        .ship(Ship.builder()
                                .shipName("Amoevan")
                                .shipContent(ShipContent.builder()
                                        .barrelsOfRum(56)
                                        .goldCoins(789)
                                        .build())
                                .build())
                        .build())
                .build();

        final Travel travelFour = Travel.builder()
                .eventType(EventType.ARRIVAL)
                .port(Port.builder()
                        .portName("Seychells+Lost+Port")
                        .ship(Ship.builder()
                                .shipName("Amoevan")
                                .shipContent(ShipContent.builder()
                                        .barrelsOfRum(56)
                                        .goldCoins(789)
                                        .build())
                                .build())
                        .build())
                .build();

        final Travel travelFive = Travel.builder()
                .eventType(EventType.ARRIVAL)
                .port(Port.builder()
                        .portName("Bahia+Occident+Port")
                        .ship(Ship.builder()
                                .shipName("Amoevan")
                                .shipContent(ShipContent.builder()
                                        .barrelsOfRum(56)
                                        .goldCoins(789)
                                        .build())
                                .build())
                        .build())
                .build();

        final Travel travelSix = Travel.builder()
                .eventType(EventType.DEPARTURE)
                .port(Port.builder()
                        .portName("Pirate+Bay+Port")
                        .ship(Ship.builder()
                                .shipName("Pirateer")
                                .shipContent(ShipContent.builder()
                                        .barrelsOfRum(100)
                                        .goldCoins(100)
                                        .build())
                                .build())
                        .build())
                .build();

        dataTravels.add(travelOne);
        dataTravels.add(travelTwo);
        dataTravels.add(travelThree);
        dataTravels.add(travelFour);
        dataTravels.add(travelFive);
        dataTravels.add(travelSix);
    }

    public static List<Travel> getDataTravel() {
        return Collections.unmodifiableList(dataTravels);
    }
}
