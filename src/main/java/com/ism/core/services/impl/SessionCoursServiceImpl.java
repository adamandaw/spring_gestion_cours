package com.ism.core.services.impl;

import com.ism.core.data.entities.*;
import com.ism.core.data.repositories.*;
import com.ism.core.services.SessionCoursService;
import com.ism.core.web.dto.request.SessionCoursDtoRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SessionCoursServiceImpl implements SessionCoursService {
    private final SessionCoursRepository sessionRepository;
    private final ParticipationCoursRepository participationCoursRepository;
    private final ClasseRepository classeRepository;
    private final SallesRepository sallesRepository;
    private final CoursRepository coursRepository;
    private final  InscriptionRepository inscriptionRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public boolean isExistByThisDate(LocalDate date, SessionDeCoursEntity sessionDeCours) {
        List<SessionDeCoursEntity> liste = sessionRepository.findAllByDateAndIsCompletedFalse(sessionDeCours.getDate());
        liste.stream().anyMatch(
                uneSession -> sessionDeCours.getDebutHeure().equals(uneSession.getDebutHeure()));
        return true;
    }

    @Override
    public  Optional<SessionDeCoursEntity> getSessionDeCoursById(Long id) {

        return sessionRepository.findById(id);
    }

    @Override
    public int setSessionToCompleted(Long id) {
        sessionRepository.majIsCompleted(id);
        return 1;
    }

    @Override
    public boolean verifyBySalleAvailable(LocalDate date, SessionCoursDtoRequest sessionDeCours) {
        if (sessionDeCours.getTypeSession().equals("En Présentiel")) {
            SalleEntity currentSalle = sessionDeCours.getSalle();
            List<SessionDeCoursEntity> liste = sessionRepository.findAllByDateAndIsCompletedFalse(sessionDeCours.getDate());

            if (liste.size() > 0) {
                boolean salleOccupee = liste.stream().anyMatch(chaqueSalle ->
                        chaqueSalle.getSalle() != null && chaqueSalle.getSalle().equals(currentSalle)
                                && chaqueSalle.getDebutHeure().equals(sessionDeCours.getDebutHeure())
                );

                return salleOccupee;
            } else {
                return false;
            }
        }

        return false;
    }


    @Override
    public void push(@PathVariable Long id, SessionCoursDtoRequest sessionCoursDtoRequest,
                      @RequestParam("typeSession") String typeSession,
                      @RequestParam("participations") Long[] participations) {

        //recherche le cours si exist ?
        Optional<CoursEntity> courById = coursRepository.findById(id);
        if (courById != null){
            CoursEntity coursEntity = courById.get();
            Integer nbrHeurePlanifier = coursEntity.getNbrHeurePlanifier();
            //conversion => Obj
            SessionDeCoursEntity session=sessionCoursDtoRequest.toEntity();
            session.setTypeSession(typeSession);
            session.setIsCompleted(false);
            session.setIsArchived(false);
            session.setCour(courById.orElseThrow());
            // Calcul de la différence d'heure
            Duration duration = Duration.between(session.getDebutHeure(),session.getFinHeure());
            int duree = Math.toIntExact(duration.toHours());

            session.setDureeHeure(duree);
            if (session.getTypeSession().equals("En ligne")) {
                session.setSalle(null);
            }else {
                session.setSalle(sessionCoursDtoRequest.getSalle());
            }
            System.out.println("\n\n********************//////////  ZONE DEBUG  //////**************************************\n\n");
            sessionRepository.save(session);
            //modification heure planifier
            int value= coursEntity.getNbrHeurePlanifier() == 0 ? duree : coursEntity.getNbrHeurePlanifier()+duree;
            coursRepository.updateNbrHeurePlanifier(coursEntity.getId(),value);
            //Classe de relation Participation
            int nbrEtudiant=0;
            AnneeScolaireEntity anneeScolaireEnCour= anneeScolaireRepository.findByIsActiveIsTrue();
            for (Long idClasse : participations) {
                ClasseEntity classe = classeRepository.findById(idClasse).orElseThrow();
                participationCoursRepository.saveAndFlush(new ParticipationCoursEntity(session,classe)) ;
                List<InscriptionEntity> inscriptions = inscriptionRepository.findByAnneeScolaireAndClasse_Id(anneeScolaireEnCour, classe.getId());
                for (int i = 0; i < inscriptions.size(); i++) {
                    InscriptionEntity inscription = inscriptions.get(i);
                    nbrEtudiant = i+1;
                }
                System.out.println("\n\n\n\nIndex  Nombre etudiant : "+ nbrEtudiant);
//                String s = verifyBySalleCapacity(nbrEtudiant, sessionCoursDtoRequest) ? "\n\nSalle peut accepter" : "\n\nplace petit";
            }
        }
    }

    @Override
    public boolean verifyBySalleCapacity(int nbrEtudiant, SessionCoursDtoRequest sessionDeCours) {
        for (int j = 1; j <= sessionDeCours.getParticipations().size(); j++) {
            nbrEtudiant = j;
            // Autres opérations à effectuer dans la boucle
        }
        Long nbrPlace = sessionDeCours.getSalle().getNbrPlace();
        System.out.println("\nNOMBRE ETUDIANT = "+nbrEtudiant);
        return nbrEtudiant <= nbrPlace;
    }

    @Override
    public Page<SessionDeCoursEntity> getAllSessionByCour(CoursEntity cours, Pageable pageable) {
        return sessionRepository.findAllByCourAndIsCompletedFalse(cours,pageable);
    }


}
//System.out.println(sessionCoursDtoRequest);
//            System.out.println("********************////////// OBJ //////**************************************\n\n");
//            System.out.println(session);
//            //System.out.println(session.getParticipationCours());
//            System.out.println("\n\n\"**********************************************************\n\n");