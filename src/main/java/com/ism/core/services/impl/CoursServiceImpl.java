package com.ism.core.services.impl;

import com.ism.core.data.entities.ModuleEntity;
import com.ism.core.data.entities.SemestreEntity;
import com.ism.core.data.repositories.ModulesRepository;
import com.ism.core.data.repositories.SemestresRepository;
import com.ism.core.services.CoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursService {
    private  final SemestresRepository semestresRepository;
    private  final ModulesRepository modulesRepository;
    @Override
    public List<SemestreEntity> getAllSemestres() {
        return semestresRepository.findAll();
    }

    @Override
    public List<ModuleEntity> getAllModules() {
        return modulesRepository.findAll();
    }
}
