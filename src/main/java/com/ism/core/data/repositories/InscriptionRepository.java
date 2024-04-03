package com.ism.core.data.repositories;

import com.ism.core.data.entities.AnneeScolaireEntity;
import com.ism.core.data.entities.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<InscriptionEntity,Long> {

    List<InscriptionEntity> findAllByAnneeScolaireIsTrueAndClasse_Id(Long classeId);
    List<InscriptionEntity> findByAnneeScolaireAndClasse_Id(AnneeScolaireEntity anneeScolaire, Long idClasse);

}
