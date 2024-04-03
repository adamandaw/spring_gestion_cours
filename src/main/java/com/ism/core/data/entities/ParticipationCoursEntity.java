package com.ism.core.data.entities;

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
@Table(name = "participations_cours")
@Builder
public class ParticipationCoursEntity extends  AbstractEntity{


    @ManyToOne
    @JoinColumn(name = "session_de_cour_id",unique = false)
    private SessionDeCoursEntity sessionDeCour;
    @ManyToOne
    @JoinColumn(name = "classe_id",unique = false)
    private ClasseEntity classe;

    @Override
    public String toString() {
        return "ParticipationCoursEntity{" +
                "sessionDeCour=" + sessionDeCour +
                ", classe=" + classe +
                '}';
    }

}
