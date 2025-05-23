package com.epf.persistance.dao;

import com.epf.persistance.entity.PlantsEntity;
import com.epf.persistance.exception.EmptyDataException;
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

    private static class PlantsRowMapper implements RowMapper<PlantsEntity> {
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

    public boolean checkId(int id) {
        String sql = "SELECT * FROM Plante WHERE id_plante = ?";
        List<PlantsEntity> result = jdbcTemplate.query(sql, new PlantsRowMapper(), id);
        if (result.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public List<PlantsEntity> getAll() throws EmptyDataException {
        String sql = "SELECT * FROM Plante";
        List<PlantsEntity> result = jdbcTemplate.query(sql, new PlantsRowMapper());
        if (result.isEmpty()) {
            throw new EmptyDataException();
        } else {
            return result;
        }
    }

    public int add(PlantsEntity entity) throws EmptyDataException {
        String sql = "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.query(sql, new PlantsRowMapper(),
                        entity.getName(),
                        entity.getHealthPoints(),
                        entity.getAttackRate(),
                        entity.getAttackDamage(),
                        entity.getPrice(),
                        entity.getSunPerSecond(),
                        Effects.intoString(entity.getEffect()),
                        entity.getImagePath());
        sql = "SELECT * FROM Plante ORDER BY id_plante DESC LIMIT 1";
        List<PlantsEntity> result = jdbcTemplate.query(sql, new PlantsRowMapper());
        if (result.isEmpty()) {
            throw new EmptyDataException();
        } else {
            return result.get(0).getId();
        }
    }

    public void update(PlantsEntity entity) throws EmptyDataException {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql,
                        entity.getName(),
                        entity.getHealthPoints(),
                        entity.getAttackRate(),
                        entity.getAttackDamage(),
                        entity.getPrice(),
                        entity.getSunPerSecond(),
                        Effects.intoString(entity.getEffect()),
                        entity.getImagePath(),
                        entity.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }
}
