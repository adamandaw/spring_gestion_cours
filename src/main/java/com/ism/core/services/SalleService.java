package com.ism.core.services;

import com.ism.core.data.entities.ClasseEntity;
import com.ism.core.data.entities.NiveauEntity;
import com.ism.core.data.entities.SalleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SalleService {


    List<SalleEntity> getAllSalles();

}
