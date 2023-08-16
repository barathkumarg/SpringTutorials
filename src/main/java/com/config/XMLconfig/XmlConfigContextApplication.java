package com.config.XMLconfig;


import com.exercise.BusinessCalculationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration
public class XmlConfigContextApplication {

    public static void main(String[] args) {

        try (var context =
                     new ClassPathXmlApplicationContext("XmlConfiguration.xml")) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));

            System.out.println(context.getBean(BusinessCalculationService.class).findMax());


        }



    }
}
