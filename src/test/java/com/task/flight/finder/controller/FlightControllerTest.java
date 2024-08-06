package com.task.flight.finder.controller;

import com.task.flight.finder.service.FlightService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

    @Mock
    FlightService flightService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testValidFindFlights() throws Exception {
        when(flightService.findFlight("flight")).thenReturn(1);

        mockMvc.perform(get("/api/v1/flights/flight")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testInvalidFindFlights() throws Exception {

        mockMvc.perform(get("/api/v1/flights/Flight")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
