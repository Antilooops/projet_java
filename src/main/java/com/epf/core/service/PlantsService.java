package com.epf.core.service;

import java.util.List;

import com.epf.core.model.Plants;
import com.epf.persistance.repository.PlantsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantsService {

    private final PlantsRepository repository;

    @Autowired
    public PlantsService(PlantsRepository repository) {
        this.repository = repository;
    }

    public List<Plants> findAll() {
        return repository.getAll();
    }

    public Plants findById(int id) {
        return repository.getById(id);
    }
}
