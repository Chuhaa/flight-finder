package com.task.flight.finder.controller;

import com.task.flight.finder.service.FlightService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to find flights
 */
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
@RestController
@Slf4j
@Validated
public class FlightController {

    private final FlightService flightService;

    /**
     * Find the instances in the given string
     * @param input the given string
     * @return the number of instances
     */
    @GetMapping("/{input}")
    public int findFlights(@PathVariable @Size(max = 100, message = "Input must not exceed 100 characters.")
                     @Pattern(regexp = "^[a-z]*$", message = "Input must only contain lowercase letters")
                     @NotBlank(message = "Input cannot be empty.") String input) {
        log.debug("String received to find {}", input);
        return flightService.findFlight(input);
    }

}
