package com.epf.persistance.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public List<MapsEntity> getMapsAll() {
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.query(sql, new MapsRowMapper());
    }

    public MapsEntity getMapById(int id) {
        String sql = "SELECT * FROM Map WHERE id_map=?";
        List<MapsEntity> maps = jdbcTemplate.query(sql, new MapsRowMapper(), id);
        return maps.isEmpty() ? null : maps.get(0);
    }
}
