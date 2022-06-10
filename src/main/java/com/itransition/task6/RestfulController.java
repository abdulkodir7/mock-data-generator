package com.itransition.task6;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Abdulqodir Ganiev 6/10/2022 1:30 AM
 */

@RestController
@RequiredArgsConstructor
public class RestfulController {

    private final AppService appService;

    @PostMapping("/api/v1/generateData")
    public List<User> generateNext10Data(@RequestBody DataRequest request) {
        return appService.generateNext10Data(request);
    }
}
