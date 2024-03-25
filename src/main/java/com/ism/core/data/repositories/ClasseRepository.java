package com.ism.core.data.repositories;

import com.ism.core.data.entities.AnneeScolaireEntity;
import com.ism.core.data.entities.ClasseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<ClasseEntity,Long> {

}
