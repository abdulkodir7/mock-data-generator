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
public class MainController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }
}
