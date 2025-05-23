package com.epf.persistance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epf.persistance.entity.ZombiesEntity;
import com.epf.persistance.exception.EmptyDataException;

@Repository
public class ZombiesDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ZombiesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class ZombiesRowMapper implements RowMapper<ZombiesEntity> {
        @Override
        public ZombiesEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ZombiesEntity(
                            rs.getInt("id_zombie"),
                            rs.getString("nom"),
                            rs.getInt("point_de_vie"),
                            rs.getFloat("attaque_par_seconde"),
                            rs.getInt("degat_attaque"),
                            rs.getFloat("vitesse_de_deplacement"),
                            rs.getString("chemin_image"),
                            rs.getInt("id_map"));
        }
    }

    public boolean checkId(int id) {
        String sql = "SELECT * FROM Zombie WHERE id_zombie = ?";
        List<ZombiesEntity> result = jdbcTemplate.query(sql, new ZombiesRowMapper(), id);
        if (result.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public List<ZombiesEntity> getAll() throws EmptyDataException {
        String sql = "SELECT * FROM Zombie";
        List<ZombiesEntity> result = jdbcTemplate.query(sql, new ZombiesRowMapper());
        if (result.isEmpty()) {
            throw new EmptyDataException();
        } else {
            return result;
        }
    }

    public int add(ZombiesEntity entity) throws EmptyDataException {
        String sql = "INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.query(sql, new ZombiesRowMapper(),
                        entity.getName(),
                        entity.getHealthPoints(),
                        entity.getAttackRate(),
                        entity.getAttackDamage(),
                        entity.getMovementSpeed(),
                        entity.getImagePath(),
                        entity.getMapId());
        sql = "SELECT * FROM Zombie ORDER BY id_zombie DESC LIMIT 1";
        List<ZombiesEntity> result = jdbcTemplate.query(sql, new ZombiesRowMapper());
        if (result.isEmpty()) {
            throw new EmptyDataException();
        } else {
            return result.get(0).getId();
        }
    }

    public void update(ZombiesEntity entity) throws EmptyDataException {
        String sql = "UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql,
                        entity.getName(),
                        entity.getHealthPoints(),
                        entity.getAttackRate(),
                        entity.getAttackDamage(),
                        entity.getMovementSpeed(),
                        entity.getImagePath(),
                        entity.getMapId(),
                        entity.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }
}
