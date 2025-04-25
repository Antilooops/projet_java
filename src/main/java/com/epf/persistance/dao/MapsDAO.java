package com.epf.persistance.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<MapsEntity> getAll() throws EmptyDataException {
        String sql = "SELECT * FROM Map";
        List<MapsEntity> result = jdbcTemplate.query(sql, new MapsRowMapper());
        if (result.isEmpty()) {
            throw new EmptyDataException();
        } else {
            return result;
        }
    }

    public int add(MapsEntity entity) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.query(sql, new MapsRowMapper(), entity.getRows(), entity.getColumns(), entity.getImagePath());
        sql = "SELECT * FROM Map ORDER BY id_map DESC LIMIT 1";
        List<MapsEntity> result = jdbcTemplate.query(sql, new MapsRowMapper());
        return result.isEmpty() ? null : result.get(0).getId();
    }

    public Map<String, Integer> delete(int id) {
        String sql = "UPDATE Zombie SET id_map = NULL WHERE id_map = ?";
        int zombiesRowAffected = jdbcTemplate.update(sql, id);
        sql = "DELETE FROM Map WHERE id_map = ?";
        int mapsRowAffected = jdbcTemplate.update(sql, id);
        Map<String, Integer> rowsAffected = new HashMap<>();
        rowsAffected.put("map_id", id);
        rowsAffected.put("maps", mapsRowAffected);
        rowsAffected.put("zombies", zombiesRowAffected);
        return rowsAffected;
    }
}
