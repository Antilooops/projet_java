package com.epf.persistance.repository;

import com.epf.model.Plants;
import com.epf.persistance.dao.PlantsDAO;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantsRepository {

    private final PlantsDAO plantsDAO;

    public PlantsRepository(PlantsDAO plantsDAO) {
        this.plantsDAO = plantsDAO;
    }

    public List<Plants> getAllPlants() {
        return this.plantsDAO.getAllPlants();
    }
}
