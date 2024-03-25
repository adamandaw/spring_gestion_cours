package com.ism.core.data.entities;

import com.ism.core.data.enums.ESemestre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "semestres")
@Builder
public class SemestreEntity extends  AbstractEntity{
    @Enumerated(value = EnumType.STRING)
    private ESemestre    libelle;

    @ManyToOne
    private NiveauEntity niveauSemestre;

    @OneToMany(mappedBy = "semestre")
    List<CoursEntity> cours;
}
