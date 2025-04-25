package com.epf.persistance.repository;

import com.epf.core.model.Maps;
import com.epf.persistance.dao.MapsDAO;
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

    public boolean checkId(int id) {
        return this.dao.checkId(id);
    }

    public List<Maps> getAll() {
        return this.entityMapper.mapListEntitiesToListModels(this.dao.getAll());
    }

    public int add(Maps model) {
        return dao.add(this.entityMapper.mapModelToEntity(model));
    }

    public void update(Maps model) {
        dao.update(this.entityMapper.mapModelToEntity(model));
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
