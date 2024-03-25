package com.ism.core.data.entities;

import com.ism.core.data.enums.ENiveau;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "niveaux")
public class NiveauEntity extends  AbstractEntity{
    @Enumerated(value = EnumType.STRING)
    private ENiveau libelle;

    @OneToMany(mappedBy = "niveau")
    private List<ClasseEntity> classes;

    @OneToMany(mappedBy = "niveauSemestre")
    private List<SemestreEntity> semestres;

}
