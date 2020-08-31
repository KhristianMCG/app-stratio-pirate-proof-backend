package com.statio.pirates.proof.service;

import com.statio.pirates.proof.entities.Travel;
import com.statio.pirates.proof.enums.EventType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = StratioProofPiratesService.class)
class StratioProofPiratesServiceTest {

    private static final String PORT_NAME = "Pirate Bay Port";
    private static final String PORT_NAME_NORMALIZED = "Pirate+Bay+Port";
    private static final String SHIP_NAME = "Oceans";
    private static final String BARRELS_OF_RUMS = "Total Barrells of Rums";
    private static final String GOLD_COINS = "Total Gold Coins";

    @Autowired
    private StratioProofPiratesService stratioProofPiratesService;

    @Test
    void returnAllTravelsHistoryByPortNameTest() {

        final List<Travel> result = this.stratioProofPiratesService.getAllTravelsByPortName(PORT_NAME, null);

        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(PORT_NAME_NORMALIZED, result.get(0).getPort().getPortName());
    }

    @Test
    void returnAllTravelsHistoryByPortNameAndEventTypeArrivalTest() {

        final List<Travel> result = this.stratioProofPiratesService.getAllTravelsByPortName(PORT_NAME, EventType.ARRIVAL.name());

        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(PORT_NAME_NORMALIZED, result.get(0).getPort().getPortName());
    }

    @Test
    void returnAllTravelsHistoryByShipNameTest() {

        final List<Travel> result = this.stratioProofPiratesService.getAllTravelsByShipName(SHIP_NAME);

        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(SHIP_NAME, result.get(0).getPort().getShip().getShipName());
    }

    @Test
    void returnCurrentStockOfAPortTest() {
        final Map<String, Integer> currentStock = this.stratioProofPiratesService.getStock(PORT_NAME);

        Assert.assertNotNull(currentStock);
        Assert.assertFalse(currentStock.isEmpty());
        Assert.assertTrue(currentStock.containsKey(BARRELS_OF_RUMS));
        Assert.assertTrue(currentStock.containsKey(GOLD_COINS));
    }
}
