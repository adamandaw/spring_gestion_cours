package com.ism.core.data.entities;

import com.ism.core.data.enums.EGrade;
import com.ism.core.data.enums.ESexe;
import com.ism.core.data.enums.ESpecialite;
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
@Table(name = "professeurs")
public class ProfesseurEntity extends AbstractPersonEntity {
    @Enumerated(value = EnumType.STRING)
    private EGrade grade;
    @Enumerated(value = EnumType.STRING)
    private ESpecialite specialite;

    @OneToMany(mappedBy = "professeur")
    List<ProfesseurClasseEntity> classes;

    @OneToMany(mappedBy = "professeur")
    private List<CoursEntity> cours;
}
