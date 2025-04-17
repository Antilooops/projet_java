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

    private final ZombiesDAO zombiesDAO;
    private final ZombiesEntityMapper zombiesMapper;

    @Autowired
    public ZombiesRepository(ZombiesDAO zombiesDAO, ZombiesEntityMapper zombiesEntityMapper) {
        this.zombiesDAO = zombiesDAO;
        this.zombiesMapper = zombiesEntityMapper;
    }

    public List<Zombies> getZombiesAll() {
        return this.zombiesMapper.mapListEntitiesToListModels(this.zombiesDAO.getZombiesAll());
    }

    public Zombies getZombieById(int id) {
        return this.zombiesMapper.mapEntityToModel(this.zombiesDAO.getZombieById(id));
    }
}
