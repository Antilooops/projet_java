package com.epf.core.service;

import java.util.List;

import com.epf.core.exception.BadAttributeException;
import com.epf.core.model.Maps;
import com.epf.persistance.repository.MapsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapsService {

    private final MapsRepository repository;

    @Autowired
    public MapsService(MapsRepository repository) {
        this.repository = repository;
    }

    public List<Maps> findAll() {
        return repository.getAll();
    }

    public int create(Maps model) {
        return repository.add(model);
    }

    public void modify(Maps model) {
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
