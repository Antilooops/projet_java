package com.epf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.config.JDBCconfig;
import com.epf.core.model.*;
import com.epf.core.service.*;
import com.epf.persistance.dao.*;
import com.epf.persistance.mapper.*;
import com.epf.persistance.repository.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCconfig.class);
        System.out.println("-------\n");

        System.out.println("-------\n");
        context.close();
    }
}
