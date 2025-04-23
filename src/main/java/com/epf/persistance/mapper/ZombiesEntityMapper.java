package com.epf.persistance.mapper;

import java.util.List;

import com.epf.core.model.Zombies;
import com.epf.persistance.entity.ZombiesEntity;

import org.springframework.stereotype.Component;

@Component
public class ZombiesEntityMapper {
    public Zombies mapEntityToModel(ZombiesEntity entity) {
        if (entity == null) {
            return null;
        }
        Zombies model = new Zombies();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setHealthPoints(entity.getHealthPoints());
        model.setAttackRate(entity.getAttackRate());
        model.setAttackDamage(entity.getAttackDamage());
        model.setMovementSpeed(entity.getMovementSpeed());
        model.setImagePath(entity.getImagePath());
        model.setMapId(entity.getMapId());
        return model;
    }

    public ZombiesEntity mapModelToEntity(Zombies model) {
        if (model == null) {
            return null;
        }
        ZombiesEntity entity = new ZombiesEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setHealthPoints(model.getHealthPoints());
        entity.setAttackRate(model.getAttackRate());
        entity.setAttackDamage(model.getAttackDamage());
        entity.setMovementSpeed(model.getMovementSpeed());
        entity.setImagePath(model.getImagePath());
        entity.setMapId(model.getMapId());
        return entity;
    }

    public List<Zombies> mapListEntitiesToListModels(List<ZombiesEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
