package com.ism.core.data.repositories;

import com.ism.core.data.entities.AnneeScolaireEntity;
import com.ism.core.data.entities.ModuleEntity;
import com.ism.core.data.entities.SemestreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModulesRepository extends JpaRepository<ModuleEntity,Long> {
    List<ModuleEntity> findAll();
}
