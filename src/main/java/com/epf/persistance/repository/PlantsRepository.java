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

    public List<Plants> getAllPlants() {
        return plantsMapper.mapListPlantsEntitiesToListPlantsModels(plantsDAO.getAllPlants());
    }

    public Plants getPlantByID(int id) {
        return plantsMapper.mapPlantEntityToPlantModel(plantsDAO.getPlantById(id));
    }
}
