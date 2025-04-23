package com.epf.persistance.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.epf.persistance.entity.MapsEntity;

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

    public List<MapsEntity> getAll() {
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.query(sql, new MapsRowMapper());
    }

    public int add(MapsEntity entity) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.query(sql, new MapsRowMapper(), entity.getRows(), entity.getColumns(), entity.getImagePath());
        sql = "SELECT * FROM Map ORDER BY id_map DESC LIMIT 1";
        List<MapsEntity> result = jdbcTemplate.query(sql, new MapsRowMapper());
        return result.isEmpty() ? null : result.get(0).getId();
    }
}
