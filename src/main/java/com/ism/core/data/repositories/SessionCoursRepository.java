package com.ism.core.data.repositories;

import com.ism.core.data.entities.CoursEntity;
import com.ism.core.data.entities.SessionDeCoursEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Transactional
public interface SessionCoursRepository extends JpaRepository<SessionDeCoursEntity,Long> {

    @Modifying
    @Query("UPDATE SessionDeCoursEntity s SET s.isCompleted = true WHERE s.id = :id")
    void majIsCompleted(@Param("id") Long id);

    Optional<SessionDeCoursEntity> findById(Long id);
    Page<SessionDeCoursEntity> findAllByCourAndIsCompletedFalse(CoursEntity cours, Pageable pageable);
    List<SessionDeCoursEntity> findAllByDateAndIsCompletedFalse(LocalDate date);
}
