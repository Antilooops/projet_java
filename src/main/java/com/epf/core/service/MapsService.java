package com.epf.core.service;

import java.util.List;

import com.epf.core.model.Maps;
import com.epf.persistance.repository.MapsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapsService {

    private final MapsRepository mapsRepository;

    @Autowired
    public MapsService(MapsRepository mapsRepository) {
        this.mapsRepository = mapsRepository;
    }

    public List<Maps> findAll() {
        return mapsRepository.getMapsAll();
    }

    public Maps findById(int id) {
        return mapsRepository.getMapById(id);
    }
}
