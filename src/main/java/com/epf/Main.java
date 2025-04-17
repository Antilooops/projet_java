package com.epf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.config.JDBCconfig;
import com.epf.persistance.dao.PlantsDAO;
import com.epf.core.model.Maps;
import com.epf.persistance.dao.MapsDAO;
import com.epf.persistance.mapper.MapsEntityMapper;
import com.epf.persistance.repository.MapsRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCconfig.class);
        System.out.println("-------\n");

        PlantsDAO plantsDAO = context.getBean(PlantsDAO.class);

        MapsDAO mapsDAO = context.getBean(MapsDAO.class);
        MapsEntityMapper mapsMapper = context.getBean(MapsEntityMapper.class);
        MapsRepository mapsRepo = new MapsRepository(mapsDAO, mapsMapper);
        List<Maps> mapList = mapsRepo.findMapsAll();
        System.out.println("-------\n");
        for (Maps maps : mapList) {
            System.out.println(maps.toString());
        }

        System.out.println("-------\n");
        context.close();
    }
}
