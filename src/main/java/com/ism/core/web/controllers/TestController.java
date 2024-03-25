package com.ism.core.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public interface TestController {
    @GetMapping("/")
    String afficher();
}
