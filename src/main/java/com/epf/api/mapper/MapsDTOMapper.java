package com.epf.api.mapper;

import java.util.List;

import com.epf.api.dto.MapsDTO;
import com.epf.core.model.Maps;
import org.springframework.stereotype.Component;

@Component
public class MapsDTOMapper {

    public MapsDTO mapModelToDTO(Maps map) {
        if (map == null) {
            return null;
        }
        MapsDTO dto = new MapsDTO();
        dto.setId(map.getId());
        dto.setRows(map.getRows());
        dto.setColumns(map.getColumns());
        dto.setImagePath(map.getImagePath());
        return dto;
    }

    public List<MapsDTO> mapListModelsToListDTOs(List<Maps> maps) {
        if (maps == null) {
            return null;
        }
        return maps.stream().map(this::mapModelToDTO).toList();
    }
}
