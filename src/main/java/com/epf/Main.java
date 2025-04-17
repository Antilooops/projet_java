package com.epf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.config.JDBCconfig;
import com.epf.core.model.Maps;
import com.epf.persistance.dao.MapsDAO;
import com.epf.persistance.mapper.MapsEntityMapper;
import com.epf.persistance.repository.MapsRepository;
import com.epf.core.model.Plants;
import com.epf.persistance.dao.PlantsDAO;
import com.epf.persistance.mapper.PlantsEntityMapper;
import com.epf.persistance.repository.PlantsRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCconfig.class);
        System.out.println("-------\n");

        MapsDAO mapsDAO = context.getBean(MapsDAO.class);
        MapsEntityMapper mapsMapper = context.getBean(MapsEntityMapper.class);
        MapsRepository mapsRepo = new MapsRepository(mapsDAO, mapsMapper);
        List<Maps> mapList = mapsRepo.getMapsAll();
        System.out.println("-------\n");
        for (Maps maps : mapList) {
            System.out.println(maps.toString());
        }

        System.out.println("-------\n");

        PlantsDAO plantsDAO = context.getBean(PlantsDAO.class);
        PlantsEntityMapper plantsMapper = context.getBean(PlantsEntityMapper.class);
        PlantsRepository plantsRepo = new PlantsRepository(plantsDAO, plantsMapper);
        List<Plants> plantList = plantsRepo.getPlantsAll();
        System.out.println("-------\n");
        for (Plants plants : plantList) {
            System.out.println(plants.toString());
        }

        System.out.println("-------\n");
        context.close();
    }
}
