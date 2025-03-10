package com.epf.persistance.dao;

import com.epf.core.model.Plants;
import com.epf.core.model.Effects;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlantsDAO {
    private final JdbcTemplate jdbcTemplate;

    public PlantsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class PlantRowMapper implements RowMapper<Plants> {
        @Override
        public Plants mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Plants(
                            rs.getInt("id_plante"),
                            rs.getString("nom"),
                            rs.getInt("point_de_vie"),
                            rs.getFloat("attaque_par_seconde"),
                            rs.getInt("degat_attaque"),
                            rs.getInt("cout"),
                            rs.getFloat("soleil_par_seconde"),
                            Effects.fromString(rs.getString("effet")),
                            rs.getString("chemin_image"));
        }
    }

    public List<Plants> getAllPlants() {
        String sql = "SELECT * FROM plants";
        return jdbcTemplate.query(sql, new PlantRowMapper());
    }

    public Optional<Plants> getPlantById(int id) {
        String sql = "SELECT * FROM plants WHERE id_plante=?";
        List<Plants> plants = jdbcTemplate.query(sql, new PlantRowMapper(), id);
        return plants.stream().findFirst();
    }
}
