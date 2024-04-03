package com.ism.core.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professeurs_classes")
public class ProfesseurClasseEntity extends  AbstractEntity{
    @ManyToOne
    private ClasseEntity classe;

    @ManyToOne
    private ProfesseurEntity professeur;

    @Override
    public String toString() {
        return "ProfesseurClasseEntity{" +
                "classe=" + classe +
                ", professeur=" + professeur +
                '}';
    }

}
