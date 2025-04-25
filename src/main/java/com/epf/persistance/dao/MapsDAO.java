package com.epf.persistance.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.epf.persistance.entity.MapsEntity;
import com.epf.persistance.exception.EmptyDataException;

@Repository
public class MapsDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MapsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class MapsRowMapper implements RowMapper<MapsEntity> {
        @Override
        public MapsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new MapsEntity(
                            rs.getInt("id_map"),
                            rs.getInt("ligne"),
                            rs.getInt("colonne"),
                            rs.getString("chemin_image"));
        }
    }

    public boolean checkId(int id) {
        String sql = "SELECT * FROM Map WHERE id_map = ?";
        List<MapsEntity> result = jdbcTemplate.query(sql, new MapsRowMapper(), id);
        if (result.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public List<MapsEntity> getAll() throws EmptyDataException {
        String sql = "SELECT * FROM Map";
        List<MapsEntity> result = jdbcTemplate.query(sql, new MapsRowMapper());
        if (result.isEmpty()) {
            throw new EmptyDataException();
        } else {
            return result;
        }
    }

    public int add(MapsEntity entity) throws EmptyDataException {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.query(sql, new MapsRowMapper(),
                        entity.getRows(),
                        entity.getColumns(),
                        entity.getImagePath());
        sql = "SELECT * FROM Map ORDER BY id_map DESC LIMIT 1";
        List<MapsEntity> result = jdbcTemplate.query(sql, new MapsRowMapper());
        if (result.isEmpty()) {
            throw new EmptyDataException();
        } else {
            return result.get(0).getId();
        }
    }

    public void update(MapsEntity entity) throws EmptyDataException {
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql,
                        entity.getRows(),
                        entity.getColumns(),
                        entity.getImagePath(),
                        entity.getId());
    }

    public void delete(int id) {
        String sql = "UPDATE Zombie SET id_map = NULL WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
        sql = "DELETE FROM Map WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
    }
}
