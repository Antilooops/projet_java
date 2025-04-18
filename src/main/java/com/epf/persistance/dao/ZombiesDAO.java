package com.epf.persistance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epf.persistance.entity.ZombiesEntity;

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

    public List<ZombiesEntity> getZombiesAll() {
        String sql = "SELECT * FROM Zombie";
        return jdbcTemplate.query(sql, new ZombiesRowMapper());
    }

    public ZombiesEntity getZombieById(int id) {
        String sql = "SELECT * FROM Zombie WHERE id_zombie=?";
        List<ZombiesEntity> zombies = jdbcTemplate.query(sql, new ZombiesRowMapper(), id);
        return zombies.isEmpty() ? null : zombies.get(0);
    }
}
