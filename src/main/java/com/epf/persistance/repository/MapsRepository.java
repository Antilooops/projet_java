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

    private final MapsDAO dao;
    private final MapsEntityMapper entityMapper;

    @Autowired
    public MapsRepository(MapsDAO dao, MapsEntityMapper entityMapper) {
        this.dao = dao;
        this.entityMapper = entityMapper;
    }

    public List<Maps> getAll() {
        return this.entityMapper.mapListEntitiesToListModels(this.dao.getAll());
    }

    public Maps getById(int id) {
        return this.entityMapper.mapEntityToModel(this.dao.getById(id));
    }
}
