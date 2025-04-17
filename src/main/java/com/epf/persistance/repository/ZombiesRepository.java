package com.epf.persistance.repository;

import com.epf.core.model.Zombies;
import com.epf.persistance.dao.ZombiesDAO;
import com.epf.persistance.mapper.ZombiesEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ZombiesRepository {

    private final ZombiesDAO dao;
    private final ZombiesEntityMapper entityMapper;

    @Autowired
    public ZombiesRepository(ZombiesDAO dao, ZombiesEntityMapper entityMapper) {
        this.dao = dao;
        this.entityMapper = entityMapper;
    }

    public List<Zombies> getAll() {
        return this.entityMapper.mapListEntitiesToListModels(this.dao.getAll());
    }

    public Zombies getById(int id) {
        return this.entityMapper.mapEntityToModel(this.dao.getById(id));
    }
}
