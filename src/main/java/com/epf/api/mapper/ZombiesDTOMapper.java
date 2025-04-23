package com.epf.api.mapper;

import java.util.List;

import com.epf.api.dto.ZombiesDTO;
import com.epf.core.model.Zombies;
import org.springframework.stereotype.Component;

@Component
public class ZombiesDTOMapper {

    public ZombiesDTO mapModelToDTO(Zombies model) {
        if (model == null) {
            return null;
        }
        ZombiesDTO dto = new ZombiesDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setHealthPoints(model.getHealthPoints());
        dto.setAttackRate(model.getAttackRate());
        dto.setAttackDamage(model.getAttackDamage());
        dto.setMovementSpeed(model.getMovementSpeed());
        dto.setImagePath(model.getImagePath());
        dto.setMapId(model.getMapId());
        return dto;
    }

    public Zombies mapDTOToModel(ZombiesDTO dto) {
        if (dto == null) {
            return null;
        }
        Zombies model = new Zombies();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setHealthPoints(dto.getHealthPoints());
        model.setAttackRate(dto.getAttackRate());
        model.setAttackDamage(dto.getAttackDamage());
        model.setMovementSpeed(dto.getMovementSpeed());
        model.setImagePath(dto.getImagePath());
        model.setMapId(dto.getMapId());
        return model;
    }

    public List<ZombiesDTO> mapListModelsToListDTOs(List<Zombies> models) {
        if (models == null) {
            return null;
        }
        return models.stream().map(this::mapModelToDTO).toList();
    }
}
