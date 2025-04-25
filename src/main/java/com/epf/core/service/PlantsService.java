package com.epf.core.service;

import java.util.List;

import com.epf.core.exception.BadAttributeException;
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

    public int create(Plants model) {
        return repository.add(model);
    }

    public void modify(Plants model) {
        if (!repository.checkId(model.getId())) {
            throw new BadAttributeException("Given id in URL doesn't correspond to any existing map id.");
        } else {
            repository.update(model);
        }
    }

    public void remove(int id) {
        repository.delete(id);
    }
}
