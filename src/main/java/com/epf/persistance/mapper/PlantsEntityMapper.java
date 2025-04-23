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
        Plants model = new Plants();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setHealthPoints(entity.getHealthPoints());
        model.setAttackRate(entity.getAttackRate());
        model.setAttackDamage(entity.getAttackDamage());
        model.setPrice(entity.getPrice());
        model.setSunPerSecond(entity.getSunPerSecond());
        model.setEffect(entity.getEffect());
        model.setImagePath(entity.getImagePath());
        return model;
    }

    public PlantsEntity mapModelToEntity(Plants model) {
        if (model == null) {
            return null;
        }
        PlantsEntity entity = new PlantsEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setHealthPoints(model.getHealthPoints());
        entity.setAttackRate(model.getAttackRate());
        entity.setAttackDamage(model.getAttackDamage());
        entity.setPrice(model.getPrice());
        entity.setSunPerSecond(model.getSunPerSecond());
        entity.setEffect(model.getEffect());
        entity.setImagePath(model.getImagePath());
        return entity;
    }

    public List<Plants> mapListEntitiesToListModels(List<PlantsEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
