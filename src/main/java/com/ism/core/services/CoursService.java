package com.ism.core.services;

import com.ism.core.data.entities.ModuleEntity;
import com.ism.core.data.entities.SemestreEntity;

import java.util.List;

public interface CoursService {
    List<SemestreEntity> getAllSemestres();
    List<ModuleEntity> getAllModules();
}
