package com.epf.persistance.mapper;

import java.util.List;

import com.epf.core.model.Plants;
import com.epf.persistance.entity.PlantsEntity;

import org.springframework.stereotype.Component;

@Component
public class PlantsEntityMapper {

    public Plants fromPlantEntitytoModel(PlantsEntity plantsEntity) {
        Plants plants = new Plants();
        plants.setId(plantsEntity.getId());
        plants.setName(plantsEntity.getName());
        plants.setHealthPoints(plantsEntity.getHealthPoints());
        plants.setAttackPerSecond(plantsEntity.getAttackPerSecond());
        plants.setAttackDamage(plantsEntity.getAttackDamage());
        plants.setPrice(plantsEntity.getPrice());
        plants.setSunPerSecond(plantsEntity.getSunPerSecond());
        plants.setEffect(plantsEntity.getEffect());
        plants.setImagePath(plantsEntity.getImagePath());
        return plants;
    }

    public List<Plants> mapListPlantsEntityToListPlantsModel(List<PlantsEntity> plantsEntities) {
        if (plantsEntities == null) {
            return null;
        }
        return plantsEntities.stream()
                        .map(this::fromPlantEntitytoModel)
                        .toList();
    }

    public Plants mapPlantEntityToPlantModel(PlantsEntity plantEntity) {
        if (plantEntity == null) {
            return null;
        } else {
            return fromPlantEntitytoModel(plantEntity);
        }
    }
}
