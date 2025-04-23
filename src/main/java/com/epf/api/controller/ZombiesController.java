package com.epf.api.controller;

import java.util.List;

import com.epf.api.dto.ZombiesDTO;
import com.epf.api.mapper.ZombiesDTOMapper;
import com.epf.core.model.Zombies;
import com.epf.core.service.ZombiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<ZombiesDTO> getAllZombies() {
        List<Zombies> zombies = service.findAll();
        return dtoMapper.mapListModelsToListDTOs(zombies);
    }

    @GetMapping("/validation")
    public List<ZombiesDTO> validationZombies() {
        List<Zombies> zombies = service.findAll();
        return dtoMapper.mapListModelsToListDTOs(zombies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZombiesDTO> getZombiesById(@PathVariable int id) {
        Zombies zombie = service.findById(id);
        if (zombie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dtoMapper.mapModelToDTO(zombie), HttpStatus.OK);
    }
}
