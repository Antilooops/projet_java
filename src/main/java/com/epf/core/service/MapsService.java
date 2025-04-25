package com.epf.core.service;

import java.util.List;
import java.util.Map;

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

    public Map<String, Integer> remove(int id) {
        return repository.delete(id);
    }
}
