package com.epf.persistance.mapper;

import java.util.List;

import com.epf.core.model.Plants;
import com.epf.persistance.entity.PlantsEntity;

import org.springframework.stereotype.Component;

@Component
public class PlantsEntityMapper {

    public Plants mapEntityToModel(PlantsEntity entity) {
        if (entity == null) {
            return null;
        }
        Plants plant = new Plants();
        plant.setId(entity.getId());
        plant.setName(entity.getName());
        plant.setHealthPoints(entity.getHealthPoints());
        plant.setAttackRate(entity.getAttackRate());
        plant.setAttackDamage(entity.getAttackDamage());
        plant.setPrice(entity.getPrice());
        plant.setSunPerSecond(entity.getSunPerSecond());
        plant.setEffect(entity.getEffect());
        plant.setImagePath(entity.getImagePath());
        return plant;
    }

    public List<Plants> mapListEntitiesToListModels(List<PlantsEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
