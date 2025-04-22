package com.epf.api.controller;

import java.util.List;

import com.epf.api.dto.PlantsDTO;
import com.epf.api.mapper.PlantsDTOMapper;
import com.epf.core.model.Plants;
import com.epf.core.service.PlantsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plants")
public class PlantsController {

    private final PlantsService service;
    private final PlantsDTOMapper dtoMapper;

    @Autowired
    public PlantsController(PlantsService service, PlantsDTOMapper dtoMapper) {
        this.service = service;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping
    public List<PlantsDTO> getAllPlants() {
        List<Plants> maps = service.findAll();
        return dtoMapper.mapListModelsToListDTOs(maps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantsDTO> getPlantsById(@PathVariable int id) {
        Plants map = service.findById(id);
        if (map == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dtoMapper.mapModelToDTO(map), HttpStatus.OK);
    }
}
