package com.ism.core.web.controllers.impl;

import com.ism.core.web.controllers.TestController;
import org.springframework.stereotype.Controller;

@Controller
public class TestControllerImpl implements TestController {
    @Override
    public String afficher() {
        System.out.println("La methode existe");
        return "/home/index";
    }
}
