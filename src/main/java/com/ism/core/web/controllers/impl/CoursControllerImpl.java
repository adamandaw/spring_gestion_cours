package com.ism.core.web.controllers.impl;

import com.ism.core.data.entities.ModuleEntity;
import com.ism.core.data.entities.SemestreEntity;
import com.ism.core.data.repositories.SemestresRepository;
import com.ism.core.services.CoursService;
import com.ism.core.web.controllers.CoursController;
import com.ism.core.web.dto.response.ModuleDtoResponse;
import com.ism.core.web.dto.response.SemetreDtoResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class CoursControllerImpl implements CoursController {
    private  final CoursService coursService;
    @Override
    public String showFormCour(Model model) {
        List<SemestreEntity> semestres = coursService.getAllSemestres();
        Stream<SemetreDtoResponse> semestreDto = semestres.stream().map(
                semestre -> SemetreDtoResponse.toDto(semestre)
        );

        List<ModuleEntity> modules = coursService.getAllModules();
        Stream<ModuleDtoResponse> modulesDto = modules.stream().map(
                moduleEntity -> ModuleDtoResponse.toDto(moduleEntity)
        );

        model.addAttribute("modules",modulesDto);
        model.addAttribute("semestres",semestreDto);

        return "cours/form-add";
    }

    @Override
    public String save() {
        return null;
    }
}
