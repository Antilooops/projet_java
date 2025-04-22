package com.epf.api.mapper;

import java.util.List;

import com.epf.api.dto.ZombiesDTO;
import com.epf.core.model.Zombies;
import org.springframework.stereotype.Component;

@Component
public class ZombiesDTOMapper {

    public ZombiesDTO mapModelToDTO(Zombies zombie) {
        if (zombie == null) {
            return null;
        }
        ZombiesDTO dto = new ZombiesDTO();
        dto.setId(zombie.getId());
        dto.setName(zombie.getName());
        dto.setHealthPoints(zombie.getHealthPoints());
        dto.setAttackRate(zombie.getAttackRate());
        dto.setAttackDamage(zombie.getAttackDamage());
        dto.setMovementSpeed(zombie.getMovementSpeed());
        dto.setImagePath(zombie.getImagePath());
        dto.setMapId(zombie.getMapId());
        return dto;
    }

    public List<ZombiesDTO> mapListModelsToListDTOs(List<Zombies> zombies) {
        if (zombies == null) {
            return null;
        }
        return zombies.stream().map(this::mapModelToDTO).toList();
    }
}
