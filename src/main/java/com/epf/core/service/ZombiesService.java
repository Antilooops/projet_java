package com.epf.core.service;

import java.util.List;

import com.epf.core.model.Zombies;
import com.epf.persistance.repository.ZombiesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZombiesService {

    private final ZombiesRepository repository;

    @Autowired
    public ZombiesService(ZombiesRepository repository) {
        this.repository = repository;
    }

    public List<Zombies> findAll() {
        return repository.getAll();
    }

    public int create(Zombies model) {
        return repository.add(model);
    }
}
