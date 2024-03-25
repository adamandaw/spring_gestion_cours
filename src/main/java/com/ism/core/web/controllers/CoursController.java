package com.ism.core.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface CoursController {

    @GetMapping("cours/new")
    String showFormCour(Model model);

    @PostMapping("save-cours")
    String save();
}
