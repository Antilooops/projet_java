package com.epf.config;

import static org.junit.jupiter.api.Assertions.*;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class DBConfigTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testDataSourceIsNotNull() {
        assertNotNull(dataSource, "DataSource should not be null");
    }

    @Test
    void testJdbcTemplateIsNotNull() {
        assertNotNull(jdbcTemplate, "JdbcTemplate should not be null");
    }

    @Test
    void testDatabaseConnection() throws Exception {
        assertNotNull(dataSource.getConnection(), "Should be able to get a database connection");
    }
}
