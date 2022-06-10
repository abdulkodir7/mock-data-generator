package com.itransition.task6;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Abdulqodir Ganiev 6/10/2022 1:30 AM
 */

@RestController
@RequiredArgsConstructor
public class RestfulController {

    private final AppService appService;

    @GetMapping("/api/v1/generateData")
    public List<User> generateNext10Data(
            @RequestParam(name = "dataLength", defaultValue = "0") int dataLength,
            @RequestParam(name = "country", defaultValue = "ru") String country,
            @RequestParam(name = "errorCount", defaultValue = "0") double errorCount,
            @RequestParam(name = "seed", defaultValue = "0") int seed
    ) {
        if (dataLength != 0)
            return appService.generateNext10Data(dataLength, country, errorCount, seed);
        return appService.generateUser(country, errorCount, seed);
    }
}
