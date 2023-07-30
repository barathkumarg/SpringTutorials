package com.learn.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        //print the bean address
        System.out.println(context.getBean("address"));

        System.out.println(context.getBean("person2MethodCall"));

        System.out.println(context.getBean("person3Parameters"));

        //calling the bean with the class type -> crates conflict when multibeans present, use primary or qualifier to resolve
        System.out.println(context.getBean(Address.class));

    }


}
