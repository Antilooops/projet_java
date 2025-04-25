package com.epf.persistance.repository;

import com.epf.core.model.Zombies;
import com.epf.persistance.dao.ZombiesDAO;
import com.epf.persistance.mapper.ZombiesEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombiesRepository {

    private final ZombiesDAO dao;
    private final ZombiesEntityMapper entityMapper;

    @Autowired
    public ZombiesRepository(ZombiesDAO dao, ZombiesEntityMapper entityMapper) {
        this.dao = dao;
        this.entityMapper = entityMapper;
    }

    public boolean checkId(int id) {
        return this.dao.checkId(id);
    }

    public List<Zombies> getAll() {
        return this.entityMapper.mapListEntitiesToListModels(this.dao.getAll());
    }

    public int add(Zombies model) {
        return dao.add(this.entityMapper.mapModelToEntity(model));
    }

    public void update(Zombies model) {
        dao.update(this.entityMapper.mapModelToEntity(model));
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
