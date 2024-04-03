package com.ism.core.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface SettingController {

@GetMapping("/setting")
    String showPageSetting();

    @GetMapping("/setting/classe")
    String showPageSettingClasse();

    @GetMapping("/setting/classe/no-active")
    String settingClasseNotActive(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5",name = "size") int size
            );
    @GetMapping("/setting/classe/{id}/active")
    String settingActiveClasse(
            @PathVariable(name = "id") Long id
    );


    @GetMapping("/setting/inscription")
    String showPageSettingInscription();

}
