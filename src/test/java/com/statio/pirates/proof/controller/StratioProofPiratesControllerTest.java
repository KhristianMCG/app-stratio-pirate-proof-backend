package com.statio.pirates.proof.controller;

import com.statio.pirates.proof.exception.ErrorTypeCode;
import com.statio.pirates.proof.exception.StratioProofPiratesException;
import com.statio.pirates.proof.repository.StratioProofPiratesRepository;
import com.statio.pirates.proof.service.StratioProofPiratesService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
class StratioProofPiratesControllerTest {

    private static final String PARAM_NAME_PORT_NAME = "portName";
    private static final String VALUE_PORT_NAME = "Bahia Occident Port";
    private static final String PARAM_NAME_SHIP_NAME = "shipName";
    private static final String VALUE_SHIP_NAME = "Oceans";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StratioProofPiratesService stratioProofPiratesService;

    @Test
    void returnAllTravelsHistoryByPortNameAndEventTypeArrival() throws Exception {
        Mockito.when(this.stratioProofPiratesService.getAllTravelsByPortName(VALUE_PORT_NAME, "")).thenReturn(StratioProofPiratesRepository.getDataTravel());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/search-travels-by-port-name/{" + PARAM_NAME_PORT_NAME + "}", VALUE_PORT_NAME).param("eventType", ""))
                .andDo(MockMvcResultHandlers
                        .print())
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.allTravels")
                        .exists())
                .andReturn();

        Mockito.verify(this.stratioProofPiratesService, Mockito.times(1)).getAllTravelsByPortName(VALUE_PORT_NAME, "");
    }

    @Test
    void returnAllTravelsHistoryByPortName() throws Exception {
        Mockito.when(this.stratioProofPiratesService.getAllTravelsByPortName(VALUE_PORT_NAME, "")).thenReturn(StratioProofPiratesRepository.getDataTravel());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/search-travels-by-port-name/{" + PARAM_NAME_PORT_NAME + "}", VALUE_PORT_NAME)
                .param("eventType", ""))
                .andDo(MockMvcResultHandlers
                        .print())
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.allTravels")
                        .exists())
                .andReturn();

        Mockito.verify(this.stratioProofPiratesService, Mockito.times(1)).getAllTravelsByPortName(VALUE_PORT_NAME, "");
    }

    @Test
    void returnAllTravelsHistoryByShipName() throws Exception {
        Mockito.when(this.stratioProofPiratesService.getAllTravelsByShipName(VALUE_SHIP_NAME)).thenReturn(StratioProofPiratesRepository.getDataTravel());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/search-travels-by-ship-name/{" + PARAM_NAME_SHIP_NAME + "}", VALUE_SHIP_NAME))
                .andDo(MockMvcResultHandlers
                        .print())
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.allTravels")
                        .exists())
                .andReturn();

        Mockito.verify(this.stratioProofPiratesService, Mockito.times(1)).getAllTravelsByShipName(VALUE_SHIP_NAME);
    }

    @Test
    void returnStockOfPortByPortName() throws Exception {
        //Given
        final Map<String, Integer> stocks = new HashMap<>();
        stocks.put("Barrels of Rums", 345);
        stocks.put("Gold coins", 23);

        //When
        Mockito.when(this.stratioProofPiratesService.getStock(VALUE_PORT_NAME)).thenReturn(stocks);

        //Then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/obtain-stock-port/{" + PARAM_NAME_PORT_NAME + "}", VALUE_PORT_NAME))
                .andDo(MockMvcResultHandlers
                        .print())
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.stocks")
                        .exists())
                .andReturn();

        Mockito.verify(this.stratioProofPiratesService, Mockito.times(1)).getStock(VALUE_PORT_NAME);
    }

    @Test
    void shouldNotFindAnyPortWithThatName() throws Exception {

        //When
        Mockito.when(this.stratioProofPiratesService.getAllTravelsByPortName(VALUE_PORT_NAME, "")).thenReturn(StratioProofPiratesRepository.getDataTravel());

        //Then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/search-travels-by-port-name/{" + PARAM_NAME_PORT_NAME + "}", "XYZ")
                .param("eventType", ""))
                .andDo(MockMvcResultHandlers
                        .print())
                .andExpect(MockMvcResultMatchers
                        .status().isBadRequest())
                .andExpect(result -> Assert.assertTrue(result.getResolvedException() instanceof StratioProofPiratesException))
                .andExpect(result -> Assert.assertEquals(ErrorTypeCode.PORT_NAME_NOT_FOUND.getDescription(), result.getResolvedException().getMessage()));
    }

    @Test
    void shouldNotFindAnyShipWithThatName() throws Exception {

        Mockito.when(this.stratioProofPiratesService.getAllTravelsByShipName(VALUE_SHIP_NAME)).thenReturn(StratioProofPiratesRepository.getDataTravel());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/search-travels-by-ship-name/{" + PARAM_NAME_SHIP_NAME + "}", "XYZ"))
                .andDo(MockMvcResultHandlers
                        .print())
                .andExpect(MockMvcResultMatchers
                        .status().isBadRequest())
                .andExpect(result -> Assert.assertTrue(result.getResolvedException() instanceof StratioProofPiratesException))
                .andExpect(result -> Assert.assertEquals(ErrorTypeCode.SHIP_NAME_NOT_FOUND.getDescription(), result.getResolvedException().getMessage()));
    }
}
