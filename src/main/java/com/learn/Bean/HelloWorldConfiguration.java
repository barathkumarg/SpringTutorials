package com.learn.Bean;

import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Eliminate verbosity in creating Java Beans
//Public accessor methods, constructor,
//equals, hashcode and toString are automatically created.
//Released in JDK 16.

//Address - firstLine & city - record feature, automatically adds the getter, setter and hash
record Address(String firstLine, String city){ };
record Person(String name,int age, Address address){};

@Configuration
public class HelloWorldConfiguration {

   //Normal bean creation

    @Bean
    public String name(){
        return "Name";
    }

    @Bean
    public int age(){
        return 25;
    }

    @Bean
    @Primary
    public Address address(){
        return new Address("13/15","Coimbatore");
    }


    //wiring the other bean to a single bean
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address()); //name, age
    }


    //pass the bean as the arguments
    //use qualifier to use the bean specified \, overiding the specific behaviour
    @Bean
    public Person person3Parameters(String name, int age, @Qualifier("customaddress") Address address3) {
        //name,age,address2
        return new Person(name, age, address3); //name, age
    }

    //adding the another address class bean with custom name
    @Bean(name = "customaddress")
    @Qualifier("customaddress")
    public Address customaddress() {return new Address("128/13","Coimbatore");}

}
