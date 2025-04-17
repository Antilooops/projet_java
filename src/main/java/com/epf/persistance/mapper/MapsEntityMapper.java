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
        Maps map = new Maps();
        map.setId(entity.getId());
        map.setRows(entity.getRows());
        map.setColumns(entity.getColumns());
        map.setImagePath(entity.getImagePath());
        return map;
    }

    public List<Maps> mapListEntitiesToListModels(List<MapsEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
