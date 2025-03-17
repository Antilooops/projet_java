package com.epf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.config.JDBCconfig;
import com.epf.persistance.dao.PlantsDAO;
import com.epf.persistance.entity.PlantsEntity;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBConfig.class);
        System.out.println("\n");

        System.out.println("\n");
        context.close();
    }
}
