package com.itransition.task6;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Abdulqodir Ganiev 6/7/2022 11:42 PM
 */

@Controller
@RequiredArgsConstructor
public class MainController {

    private final AppService appService;

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @PostMapping("/")
    public String generateData(Model model,
                               @RequestParam(required = false) String country,
                               @RequestParam(required = false) String error,
                               @RequestParam(required = false) String seed) {

        List<User> users = appService.generateUser(country, error, seed);
        model.addAttribute("country", country);
        model.addAttribute("error", error);
        model.addAttribute("seed", seed);
        model.addAttribute("users", users);
        return "index";
    }


}
