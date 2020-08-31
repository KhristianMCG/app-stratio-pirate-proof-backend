package com.statio.pirates.proof.controller;

import com.statio.pirates.proof.entities.Travel;
import com.statio.pirates.proof.exception.ErrorTypeCode;
import com.statio.pirates.proof.exception.StratioProofPiratesException;
import com.statio.pirates.proof.model.StratioProofPiratesResponse;
import com.statio.pirates.proof.service.StratioProofPiratesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class StratioProofPiratesController {

    private final StratioProofPiratesService stratioProofPiratesService;

    public StratioProofPiratesController(final StratioProofPiratesService stratioProofPiratesService) {
        this.stratioProofPiratesService = stratioProofPiratesService;
    }

    @GetMapping(path = "/search-travels-by-port-name/{portName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StratioProofPiratesResponse> searchTravelsByPortName(@PathVariable final String portName, @RequestParam(value = "eventType", required = false) final String eventType) {
        final List<Travel> travels = this.stratioProofPiratesService.getAllTravelsByPortName(portName, eventType);

        if (travels.isEmpty()) {
            throw new StratioProofPiratesException(ErrorTypeCode.PORT_NAME_NOT_FOUND);
        }

        return ResponseEntity.ok(StratioProofPiratesResponse.builder()
                .allTravels(travels)
                .build());
    }

    @GetMapping(path = "/search-travels-by-ship-name/{shipName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StratioProofPiratesResponse> searchTravelsByShipName(@PathVariable final String shipName) {
        final List<Travel> travels = this.stratioProofPiratesService.getAllTravelsByShipName(shipName);

        if (travels.isEmpty()) {
            throw new StratioProofPiratesException(ErrorTypeCode.SHIP_NAME_NOT_FOUND);
        }

        return ResponseEntity.ok(StratioProofPiratesResponse.builder()
                .allTravels(travels)
                .build());
    }

    @GetMapping(path = "/obtain-stock-port/{portName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StratioProofPiratesResponse> obtainStockPort(@PathVariable final String portName) {
        final Map<String, Integer> stocks = this.stratioProofPiratesService.getStock(portName);

        if (stocks.isEmpty()) {
            throw new StratioProofPiratesException(ErrorTypeCode.PORT_NAME_NOT_FOUND);
        }

        return ResponseEntity.ok(StratioProofPiratesResponse.builder()
                .stocks(stocks)
                .build());
    }
}
