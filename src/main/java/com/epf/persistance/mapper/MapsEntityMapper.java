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
        Maps model = new Maps();
        model.setId(entity.getId());
        model.setRows(entity.getRows());
        model.setColumns(entity.getColumns());
        model.setImagePath(entity.getImagePath());
        return model;
    }

    public MapsEntity mapModelToEntity(Maps model) {
        if (model == null) {
            return null;
        }
        MapsEntity entity = new MapsEntity();
        entity.setId(model.getId());
        entity.setRows(model.getRows());
        entity.setColumns(model.getColumns());
        entity.setImagePath(model.getImagePath());
        return entity;
    }

    public List<Maps> mapListEntitiesToListModels(List<MapsEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
