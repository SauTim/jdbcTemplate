package ru.tim.springjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
    @GetMapping("/lib")
    public String getView() {
        return "library_view";
    }
}
