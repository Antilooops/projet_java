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
        Zombies zombie = new Zombies();
        zombie.setId(entity.getId());
        zombie.setName(entity.getName());
        zombie.setHealthPoints(entity.getHealthPoints());
        zombie.setAttackRate(entity.getAttackRate());
        zombie.setAttackDamage(entity.getAttackDamage());
        zombie.setMovementSpeed(entity.getMovementSpeed());
        zombie.setImagePath(entity.getImagePath());
        zombie.setMapId(entity.getMapId());
        return zombie;
    }

    public List<Zombies> mapListEntitiesToListModels(List<ZombiesEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
