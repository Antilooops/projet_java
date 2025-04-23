package com.epf.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epf.api.dto.PlantsDTO;
import com.epf.api.mapper.PlantsDTOMapper;
import com.epf.core.model.Plants;
import com.epf.core.service.PlantsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plantes")
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
        List<Plants> models = service.findAll();
        return dtoMapper.mapListModelsToListDTOs(models);
    }

    @GetMapping("/validation")
    public List<PlantsDTO> validationPlants() {
        List<Plants> models = service.findAll();
        return dtoMapper.mapListModelsToListDTOs(models);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPlant(@RequestBody PlantsDTO dto) {
        try {
            Plants model = dtoMapper.mapDTOToModel(dto);
            int id = service.create(model);
            Map<String, Object> response = new HashMap<>();
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
