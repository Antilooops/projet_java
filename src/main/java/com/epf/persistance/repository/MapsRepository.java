package com.epf.persistance.repository;

import com.epf.core.model.Maps;
import com.epf.persistance.dao.MapsDAO;
import com.epf.persistance.mapper.MapsEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MapsRepository {

    private final MapsDAO mapsDAO;
    private final MapsEntityMapper mapsMapper;

    @Autowired
    public MapsRepository(MapsDAO mapsDAO, MapsEntityMapper mapsEntityMapper) {
        this.mapsDAO = mapsDAO;
        this.mapsMapper = mapsEntityMapper;
    }

    public List<Maps> getMapsAll() {
        return this.mapsMapper.mapListEntitiesToListModels(this.mapsDAO.getMapsAll());
    }

    public Maps getMapsById(int id) {
        return this.mapsMapper.mapEntityToModel(this.mapsDAO.getMapById(id));
    }
}
