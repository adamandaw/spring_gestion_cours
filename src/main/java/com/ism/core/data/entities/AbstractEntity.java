package com.ism.core.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
public class AbstractEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isArchived;

    public AbstractEntity(){
        this.isArchived=false;
    }
}
