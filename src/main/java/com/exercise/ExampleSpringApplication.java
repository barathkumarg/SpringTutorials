package com.exercise;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@Configuration
@ComponentScan("com.exercise")
public class ExampleSpringApplication {

    public static void main(String[] args) {

        //create the Application context
        var context = new AnnotationConfigApplicationContext(ExampleSpringApplication.class);

        //get the component
        //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        //retrive the bean data, will execute the MongoDB service as specified Primary annotation.
        System.out.println(context.getBean(BusinessCalculationService.class).findMax());


    }
}
