package com.epf.persistance.mapper;

import java.util.List;

import com.epf.core.model.Plants;
import com.epf.persistance.entity.PlantsEntity;

import org.springframework.stereotype.Component;

@Component
public class PlantsEntityMapper {

    public Plants mapPlantEntitytoModel(PlantsEntity entity) {
        if (entity == null) {
            return null;
        }
        Plants plants = new Plants();
        plants.setId(entity.getId());
        plants.setName(entity.getName());
        plants.setHealthPoints(entity.getHealthPoints());
        plants.setAttackPerSecond(entity.getAttackPerSecond());
        plants.setAttackDamage(entity.getAttackDamage());
        plants.setPrice(entity.getPrice());
        plants.setSunPerSecond(entity.getSunPerSecond());
        plants.setEffect(entity.getEffect());
        plants.setImagePath(entity.getImagePath());
        return plants;
    }

    public List<Plants> mapListEntitiesToListModels(List<PlantsEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                        .map(this::mapPlantEntitytoModel)
                        .toList();
    }
}
