package com.epf.persistance.repository;

import com.epf.core.model.Maps;
import com.epf.persistance.dao.MapsDAO;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapsRepository {

    private final MapsDAO mapsDAO;

    public MapsRepository(MapsDAO mapsDAO) {
        this.mapsDAO = mapsDAO;
    }

    public List<Maps> getAllMaps() {
        return this.mapsDAO.getAllMaps();
    }
}
