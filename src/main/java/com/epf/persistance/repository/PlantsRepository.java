package com.epf.persistance.repository;

import com.epf.core.model.Plants;
import com.epf.persistance.dao.PlantsDAO;
import com.epf.persistance.mapper.PlantsEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantsRepository {

    private final PlantsDAO plantsDAO;
    private final PlantsEntityMapper plantsMapper;

    @Autowired
    public PlantsRepository(PlantsDAO plantsDAO, PlantsEntityMapper plantsEntityMapper) {
        this.plantsDAO = plantsDAO;
        this.plantsMapper = plantsEntityMapper;
    }

    public List<Plants> getPlantsAll() {
        return plantsMapper.mapListEntitiesToListModels(plantsDAO.getPlantsAll());
    }

    public Plants getPlantById(int id) {
        return plantsMapper.mapPlantEntitytoModel(plantsDAO.getPlantById(id));
    }
}
