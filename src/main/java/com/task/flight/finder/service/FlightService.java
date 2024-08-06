package com.task.flight.finder.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Service to find flights
 */
@Service
@Slf4j
public class FlightService {

    private static final String FLIGHT = "flight";
    private final char[] FLIGHT_ARRAY = FLIGHT.toCharArray();

    /**
     * Find the instances of the given string
     * @param input the given string
     * @return the number of instances
     */
    public int findFlight(String input) {

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : FLIGHT_ARRAY) {
            map.put(c, 0);
        }

        for (int i = 0; i < input.length(); i++) {
            map.computeIfPresent(input.charAt(i), (key, count) -> count + 1);
        }

        int times = Collections.min(map.values());
        log.debug("Returning the  instances for the given string {}: {}", input, times);
        return times;

    }
}
