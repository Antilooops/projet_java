package com.epf.core.service;

import java.util.List;

import com.epf.core.exception.BadAttributeException;
import com.epf.core.model.Zombies;
import com.epf.persistance.repository.ZombiesRepository;
import com.epf.persistance.repository.MapsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZombiesService {

    private final ZombiesRepository repository;
    private final MapsRepository mapsRepository;

    @Autowired
    public ZombiesService(ZombiesRepository repository, MapsRepository mapsRepository) {
        this.repository = repository;
        this.mapsRepository = mapsRepository;
    }

    public List<Zombies> findAll() {
        return repository.getAll();
    }

    public int create(Zombies model) throws BadAttributeException {
        if (!mapsRepository.checkId(model.getMapId())) {
            throw new BadAttributeException("Mapid doesn't correspond to an existing map id.");
        } else {
            return repository.add(model);
        }
    }

    public void modify(Zombies model) {
        if (!repository.checkId(model.getId())) {
            throw new BadAttributeException("Given id in URL doesn't correspond to any existing map id.");
        } else if (!mapsRepository.checkId(model.getMapId())) {
            throw new BadAttributeException("Mapid doesn't correspond to an existing map id.");
        } else {
            repository.update(model);
        }
    }

    public void remove(int id) {
        repository.delete(id);
    }
}
