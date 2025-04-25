package com.epf.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epf.api.dto.ZombiesDTO;
import com.epf.api.exception.BadPathVariableException;
import com.epf.api.mapper.ZombiesDTOMapper;
import com.epf.core.exception.BadAttributeException;
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
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Object> getAll() {
        try {
            List<Zombies> models = service.findAll();
            List<ZombiesDTO> dtos = dtoMapper.mapListModelsToListDTOs(models);
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        } catch (EmptyDataException e) {
            System.out.println(e);
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("message", "no zombie found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e);
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "internal server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/validation")
    public List<ZombiesDTO> validation() {
        List<Zombies> models = service.findAll();
        return dtoMapper.mapListModelsToListDTOs(models);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody ZombiesDTO dto) {
        try {
            Zombies model = dtoMapper.mapDTOToModel(dto);
            int id = service.create(model);
            Map<String, Object> response = new HashMap<>();
            response.put("id", id);
            response.put("message", "zombie created successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (BadAttributeException e) {
            System.out.println(e);
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "internal server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> modify(@PathVariable("id") int id, @RequestBody ZombiesDTO dto) {
        try {
            if (id < 0) {
                throw new BadPathVariableException("Pathvariable cannot be negative");
            }
            dto.setId(id);
            Zombies model = dtoMapper.mapDTOToModel(dto);
            service.modify(model);
            Map<String, Object> response = new HashMap<>();
            response.put("id", id);
            response.put("message", "zombie updated successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadPathVariableException e) {
            System.out.println(e);
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (BadAttributeException e) {
            System.out.println(e);
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "internal server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        try {
            if (id < 0) {
                throw new BadPathVariableException("Pathvariable cannot be negative");
            }
            service.remove(id);
            Map<String, Object> response = new HashMap<>();
            response.put("id", id);
            response.put("message", "zombie deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadPathVariableException e) {
            System.out.println(e);
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            Map<String, Object> response = new HashMap<>();
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "internal server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
