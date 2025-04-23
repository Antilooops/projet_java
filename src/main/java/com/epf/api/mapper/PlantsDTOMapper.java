package com.epf.api.mapper;

import java.util.List;

import com.epf.api.dto.PlantsDTO;
import com.epf.core.model.Plants;
import org.springframework.stereotype.Component;

@Component
public class PlantsDTOMapper {

    public PlantsDTO mapModelToDTO(Plants model) {
        if (model == null) {
            return null;
        }
        PlantsDTO dto = new PlantsDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setHealthPoints(model.getHealthPoints());
        dto.setAttackRate(model.getAttackRate());
        dto.setAttackDamage(model.getAttackDamage());
        dto.setPrice(model.getPrice());
        dto.setSunPerSecond(model.getSunPerSecond());
        dto.setEffect(model.getEffect());
        dto.setImagePath(model.getImagePath());
        return dto;
    }

    public Plants mapDTOToModel(PlantsDTO dto) {
        if (dto == null) {
            return null;
        }
        Plants model = new Plants();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setHealthPoints(dto.getHealthPoints());
        model.setAttackRate(dto.getAttackRate());
        model.setAttackDamage(dto.getAttackDamage());
        model.setPrice(dto.getPrice());
        model.setSunPerSecond(dto.getSunPerSecond());
        model.setEffect(dto.getEffect());
        model.setImagePath(dto.getImagePath());
        return model;
    }

    public List<PlantsDTO> mapListModelsToListDTOs(List<Plants> models) {
        if (models == null) {
            return null;
        }
        return models.stream().map(this::mapModelToDTO).toList();
    }
}
