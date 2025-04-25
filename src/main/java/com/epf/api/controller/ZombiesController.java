package com.epf.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epf.api.dto.ZombiesDTO;
import com.epf.api.mapper.ZombiesDTOMapper;
import com.epf.core.model.Zombies;
import com.epf.core.service.ZombiesService;
import com.epf.persistance.exception.EmptyDataException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zombies")
public class ZombiesController {

    private final ZombiesService service;
    private final ZombiesDTOMapper dtoMapper;

    @Autowired
    public ZombiesController(ZombiesService service, ZombiesDTOMapper dtoMapper) {
        this.service = service;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping()
    public ResponseEntity<List<ZombiesDTO>> getAllPlants() {
        try {
            List<Zombies> models = service.findAll();
            List<ZombiesDTO> dtos = dtoMapper.mapListModelsToListDTOs(models);
            return ResponseEntity.ok(dtos);
        } catch (EmptyDataException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/validation")
    public List<ZombiesDTO> validationZombies() {
        List<Zombies> models = service.findAll();
        return dtoMapper.mapListModelsToListDTOs(models);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createZombie(@RequestBody ZombiesDTO dto) {
        try {
            Zombies model = dtoMapper.mapDTOToModel(dto);
            int id = service.create(model);
            Map<String, Object> response = new HashMap<>();
            response.put("id", id);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePlant(@PathVariable("id") int id) {
        try {
            int rowsAffected = service.remove(id);
            Map<String, Object> response = new HashMap<>();
            response.put("id", id);
            response.put("deleted", rowsAffected);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
