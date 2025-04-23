package com.epf.persistance.dao;

import com.epf.persistance.entity.PlantsEntity;
import com.epf.core.model.Effects;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantsDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlantsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class PlantRowMapper implements RowMapper<PlantsEntity> {
        @Override
        public PlantsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new PlantsEntity(
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

    public List<PlantsEntity> getAll() {
        String sql = "SELECT * FROM Plante";
        return jdbcTemplate.query(sql, new PlantRowMapper());
    }

    public PlantsEntity getById(int id) {
        String sql = "SELECT * FROM Plante WHERE id_plante=?";
        List<PlantsEntity> plantes = jdbcTemplate.query(sql, new PlantRowMapper(), id);
        return plantes.isEmpty() ? null : plantes.get(0);
    }
}
