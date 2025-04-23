package com.epf.api.mapper;

import java.util.List;

import com.epf.api.dto.MapsDTO;
import com.epf.core.model.Maps;
import org.springframework.stereotype.Component;

@Component
public class MapsDTOMapper {

    public MapsDTO mapModelToDTO(Maps model) {
        if (model == null) {
            return null;
        }
        MapsDTO dto = new MapsDTO();
        dto.setId(model.getId());
        dto.setRows(model.getRows());
        dto.setColumns(model.getColumns());
        dto.setImagePath(model.getImagePath());
        return dto;
    }

    public Maps mapDTOToModel(MapsDTO dto) {
        if (dto == null) {
            return null;
        }
        Maps model = new Maps();
        model.setId(dto.getId());
        model.setRows(dto.getRows());
        model.setColumns(dto.getColumns());
        model.setImagePath(dto.getImagePath());
        return model;
    }

    public List<MapsDTO> mapListModelsToListDTOs(List<Maps> models) {
        if (models == null) {
            return null;
        }
        return models.stream().map(this::mapModelToDTO).toList();
    }
}
