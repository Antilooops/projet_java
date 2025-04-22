package com.epf.api.controller;

import java.util.List;

import com.epf.api.dto.MapsDTO;
import com.epf.api.mapper.MapsDTOMapper;
import com.epf.core.model.Maps;
import com.epf.core.service.MapsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps")
public class MapsController {

    private final MapsService service;
    private final MapsDTOMapper dtoMapper;

    @Autowired
    public MapsController(MapsService service, MapsDTOMapper dtoMapper) {
        this.service = service;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping
    public List<MapsDTO> getAllMaps() {
        List<Maps> maps = service.findAll();
        return dtoMapper.mapListModelsToListDTOs(maps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapsDTO> getMapsById(@PathVariable int id) {
        Maps map = service.findById(id);
        if (map == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dtoMapper.mapModelToDTO(map), HttpStatus.OK);
    }
}
