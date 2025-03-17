package com.epf.persistance.dao;

import com.epf.persistance.entity.PlantsEntity;
import com.epf.core.model.Effects;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class PlantsDAO {

    private static final Logger logger = LoggerFactory.getLogger(PlantsDAO.class);
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

    public List<PlantsEntity> getAllPlants() {
        String sql = "SELECT * FROM Plante";
        try {
            List<PlantsEntity> plantList = jdbcTemplate.query(sql, new PlantRowMapper());
            if (plantList.isEmpty()) {
                logger.warn("No plants found in database");
                throw new PlantNotFoundException("No plants found in the database");
            }
            return plantList;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return Collections.emptyList();
        } catch (PlantNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public PlantsEntity getPlantById(int id) {
        String sql = "SELECT * FROM Plante WHERE id_plante=?";
        try {
            List<PlantsEntity> plant = jdbcTemplate.query(sql, new PlantRowMapper(), id);
            if (plant.isEmpty()) {
                throw new RuntimeException("ERROR = plant with ID " + id + " not found.");
            }
            return plant.get(0);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new PlantsEntity();
        }
    }

    public static class PlantDataException extends Exception {
        public PlantDataException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class PlantNotFoundException extends PlantDataException {
        public PlantNotFoundException(String message) {
            super(message, null);
        }
    }
}
