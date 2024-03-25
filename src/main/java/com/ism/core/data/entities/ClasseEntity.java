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

@Table(name = "classes")
public class ClasseEntity  extends  AbstractEntity{
    @OneToMany(mappedBy = "classe")
    List<ProfesseurClasseEntity> professeurClasses;

    @ManyToOne
    private NiveauEntity niveau;

    @ManyToOne
    private FiliereEntity filiere;

    @OneToMany(mappedBy = "classe")
    private List<InscriptionEntity> inscriptions;

    @Column(unique = false,nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "classe")
    private  List<ClasseModuleEntity> modules;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean coursIsOpen;

    public ClasseEntity(){
        this.coursIsOpen=false;
  }
}
