package com.ism.core.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor

@Table(name = "cours")
public class CoursEntity extends  AbstractEntity{

    private Integer nbrHeureGlobal;

    private  Integer nbrHeurePlanifier;

    private Integer nbrHeureEffectuer;
    @ManyToOne
    private SemestreEntity semestre;
    @ManyToOne
    private AnneeScolaireEntity anneeScolaire;
    @ManyToOne
    private ModuleEntity module;
    @ManyToOne
    private ProfesseurEntity professeur;

    public CoursEntity(){
        this.nbrHeureEffectuer=0;
        this.nbrHeurePlanifier=0;
    }


}
