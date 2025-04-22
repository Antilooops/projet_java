package com.epf.api.mapper;

import java.util.List;

import com.epf.api.dto.PlantsDTO;
import com.epf.core.model.Plants;
import org.springframework.stereotype.Component;

@Component
public class PlantsDTOMapper {

    public PlantsDTO mapModelToDTO(Plants plant) {
        if (plant == null) {
            return null;
        }
        PlantsDTO dto = new PlantsDTO();
        dto.setId(plant.getId());
        dto.setName(plant.getName());
        dto.setHealthPoints(plant.getHealthPoints());
        dto.setAttackRate(plant.getAttackRate());
        dto.setAttackDamage(plant.getAttackDamage());
        dto.setPrice(plant.getPrice());
        dto.setSunPerSecond(plant.getSunPerSecond());
        dto.setEffect(plant.getEffect());
        dto.setImagePath(plant.getImagePath());
        return dto;
    }

    public List<PlantsDTO> mapListModelsToListDTOs(List<Plants> plants) {
        if (plants == null) {
            return null;
        }
        return plants.stream().map(this::mapModelToDTO).toList();
    }
}
