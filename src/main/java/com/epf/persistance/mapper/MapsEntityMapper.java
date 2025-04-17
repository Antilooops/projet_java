package com.epf.persistance.mapper;

import java.util.List;

import com.epf.core.model.Maps;
import com.epf.persistance.entity.MapsEntity;

import org.springframework.stereotype.Component;

@Component
public class MapsEntityMapper {

    public Maps mapEntityToModel(MapsEntity entity) {
        if (entity == null) {
            return null;
        }
        Maps maps = new Maps();
        maps.setId(entity.getId());
        maps.setRows(entity.getRows());
        maps.setColumns(entity.getColumns());
        maps.setImagePath(entity.getImagePath());
        return maps;
    }

    public List<Maps> mapListEntityToListModel(List<MapsEntity> entities) {
        return entities.stream()
                        .map(this::mapEntityToModel)
                        .toList();
    }
}
