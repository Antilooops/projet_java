package com.epf.persistance.repository;

import com.epf.core.model.Plants;
import com.epf.persistance.dao.PlantsDAO;
import com.epf.persistance.mapper.PlantsEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantsRepository {

    private final PlantsDAO dao;
    private final PlantsEntityMapper entityMapper;

    @Autowired
    public PlantsRepository(PlantsDAO dao, PlantsEntityMapper entityMapper) {
        this.dao = dao;
        this.entityMapper = entityMapper;
    }

    public boolean checkId(int id) {
        return this.dao.checkId(id);
    }

    public List<Plants> getAll() {
        return this.entityMapper.mapListEntitiesToListModels(dao.getAll());
    }

    public int add(Plants model) {
        return dao.add(this.entityMapper.mapModelToEntity(model));
    }

    public void update(Plants model) {
        dao.update(this.entityMapper.mapModelToEntity(model));
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
