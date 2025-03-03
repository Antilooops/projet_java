package com.epf.persistance;

import com.epf.JdbcTemplate;

import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Bean;

import com.mysql.cj.jdbc.MysqlDataSource;

@Repository
public class DataSource {

    @Bean
    public MysqlDataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("louis");
        dataSource.setPassword("Okayletsgo123");
        dataSource.setServerName("");
        dataSource.setPort(3301);
        dataSource.setDatabaseName("pvz");
        return dataSource;
    }

    @Bean
    public void jdbcTemplate(MysqlDataSource dataSource) {
        // return new JdbcTemplate(dataSource);
    }

}
