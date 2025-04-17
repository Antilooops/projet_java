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

    public List<Plants> getAll() {
        return entityMapper.mapListEntitiesToListModels(dao.getAll());
    }

    public Plants getById(int id) {
        return entityMapper.mapPlantEntitytoModel(dao.getById(id));
    }
}
