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
@Table(name = "modules")
public class ModuleEntity extends  AbstractEntity{

    @Column(unique = false,nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "module")
    private  List<ClasseModuleEntity> modules;

    @OneToMany(mappedBy = "module")
    private List<CoursEntity> cours;

    @Override
    public String toString() {
        return "ModuleEntity{" +
                "libelle='" + libelle + '\'' +

                '}';
    }
}
