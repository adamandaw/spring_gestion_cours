package com.ism.core.services;

import com.ism.core.data.entities.CoursEntity;
import com.ism.core.data.entities.SessionDeCoursEntity;
import com.ism.core.web.dto.request.SessionCoursDtoRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

public interface SessionCoursService {
    boolean isExistByThisDate(LocalDate date, SessionDeCoursEntity sessionDeCours);

    Optional<SessionDeCoursEntity> getSessionDeCoursById(Long id);

    int setSessionToCompleted(Long id);

    boolean verifyBySalleAvailable(LocalDate date, SessionCoursDtoRequest sessionDeCours);

    boolean verifyBySalleCapacity(int nbrEtudiant ,SessionCoursDtoRequest sessionDeCours);
    void push(@PathVariable Long id, SessionCoursDtoRequest sessionCoursDtoRequest,
               @RequestParam("typeSession") String typeSession,
               @RequestParam("participations") Long[] participations);

    Page<SessionDeCoursEntity> getAllSessionByCour(CoursEntity cours, Pageable pageable);


}
