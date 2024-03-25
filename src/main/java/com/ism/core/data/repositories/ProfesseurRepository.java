package com.ism.core.data.repositories;

import com.ism.core.data.entities.EtudiantEntity;
import com.ism.core.data.entities.ProfesseurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<ProfesseurEntity,Long> {

}
