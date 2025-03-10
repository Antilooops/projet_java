package com.epf.persistance.dao;

import com.epf.model.Maps;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MapsDAO {
    private final JdbcTemplate jdbcTemplate;

    public MapsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class MapsRowMapper implements RowMapper<Maps> {
        @Override
        public Maps mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Maps(
                            rs.getInt("id_map"),
                            rs.getInt("ligne"),
                            rs.getInt("colonne"),
                            rs.getString("chemin_image"));
        }
    }

    public List<Maps> getAllMaps() {
        String sql = "SELECT * FROM maps";
        return jdbcTemplate.query(sql, new MapsRowMapper());
    }

    public Optional<Maps> getMapsById(int id) {
        String sql = "SELECT * FROM maps WHERE id_map=?";
        List<Maps> maps = jdbcTemplate.query(sql, new MapsRowMapper(), id);
        return maps.stream().findFirst();
    }
}
