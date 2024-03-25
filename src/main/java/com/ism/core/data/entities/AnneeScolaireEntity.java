package com.ism.core.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "annees_scolaires")
public class AnneeScolaireEntity extends  AbstractEntity{
    @Column(unique = true,nullable = false)
    private String libelle;

    private Boolean isActive;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateDeCloturation;

    @OneToMany(mappedBy = "anneeScolaire")
    private List<InscriptionEntity> inscriptions;

    @OneToMany(mappedBy = "anneeScolaire")
    private List<CoursEntity> cours;

}
