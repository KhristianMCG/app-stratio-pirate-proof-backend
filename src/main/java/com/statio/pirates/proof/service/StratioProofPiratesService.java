package com.statio.pirates.proof.service;

import com.statio.pirates.proof.entities.Travel;
import com.statio.pirates.proof.repository.StratioProofPiratesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StratioProofPiratesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StratioProofPiratesService.class);

    public List<Travel> getAllTravelsByPortName(final String portName, final String eventType) {
        return (eventType == null || eventType.isEmpty()) ? this.getTravelsNonFiltered(portName) : this.getTravelsFiltered(portName, eventType);
    }

    private List<Travel> getTravelsFiltered(final String portName, final String eventType) {
        return StratioProofPiratesRepository.getDataTravel()
                .stream()
                .filter(travel -> travel.getPort().getPortName().equals(this.normalizeName(portName)) && travel.getEventType().name().equals(eventType))
                .collect(Collectors.toList());
    }

    private List<Travel> getTravelsNonFiltered(final String portName) {
        return StratioProofPiratesRepository.getDataTravel()
                .stream()
                .filter(travel -> travel.getPort().getPortName().equals(this.normalizeName(portName)))
                .collect(Collectors.toList());
    }

    private String normalizeName(final String portName) {
        try {
            return URLEncoder.encode(portName, "UTF-8").replace("%20", "+");
        } catch (final UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    public List<Travel> getAllTravelsByShipName(final String shipName) {
        return StratioProofPiratesRepository.getDataTravel()
                .stream()
                .filter(travel -> travel.getPort().getShip().getShipName().equals(shipName))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getStock(final String portName) {
        final Map<String, Integer> stocks = new HashMap<>();

        stocks.put("Total Barrells of Rums", this.getTotalBarrellsOfRums(portName));
        stocks.put("Total Gold Coins", this.getTotalGoldCoins(portName));

        return Collections.unmodifiableMap(stocks);
    }

    private int getTotalBarrellsOfRums(final String portName) {
        return StratioProofPiratesRepository.getDataTravel()
                .stream()
                .filter(travel -> travel.getPort().getPortName().equals(portName))
                .mapToInt(travel -> travel.getPort().getShip().getShipContent().getBarrelsOfRum())
                .sum();
    }

    private int getTotalGoldCoins(final String portName) {
        return StratioProofPiratesRepository.getDataTravel()
                .stream()
                .filter(travel -> travel.getPort().getPortName().equals(portName))
                .mapToInt(travel -> travel.getPort().getShip().getShipContent().getGoldCoins())
                .sum();
    }
}
