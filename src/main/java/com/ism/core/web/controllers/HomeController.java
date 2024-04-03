package com.ism.core.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HomeController {
    @GetMapping("/")
    String home(Model model,
                @RequestParam(defaultValue = "0",name = "page") int page,
                @RequestParam(defaultValue = "5",name = "size") int size);

    @GetMapping("/page/404")
    String pageNotFound(Model model);
}
