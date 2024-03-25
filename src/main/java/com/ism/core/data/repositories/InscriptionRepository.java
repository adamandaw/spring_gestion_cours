package com.ism.core.data.repositories;

import com.ism.core.data.entities.AnneeScolaireEntity;
import com.ism.core.data.entities.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<InscriptionEntity,Long> {

}
