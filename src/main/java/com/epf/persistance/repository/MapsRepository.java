package com.epf.persistance.repository;

import com.epf.core.model.Maps;
import com.epf.persistance.dao.MapsDAO;
import com.epf.persistance.entity.MapsEntity;
import com.epf.persistance.mapper.MapsEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public int add(Maps model) {
        MapsEntity entity = this.entityMapper.mapModelToEntity(model);
        return dao.add(entity);
    }
}
