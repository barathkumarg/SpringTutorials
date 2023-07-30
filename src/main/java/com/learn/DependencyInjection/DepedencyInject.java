package com.learn.DependencyInjection;

import com.learn.GameApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

//Dependecy injection - where one class depends on another class for execution
@Component
class Dependency1{

}

@Component
class Dependency2{

}


@Component
class Mainclass{

    //Field Dependency using Autowired Annotation
//    @Autowired
    Dependency1 dependency1;
    //
//    @Autowired
    Dependency2 dependency2;


    //Using the Dependency via setters method
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Injection - setDependency1 ");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Injection - setDependency2 ");
//        this.dependency2 = dependency2;
//    }


    //using the dependency injection as the constructor loading -> Here autowired annotation is optional, it was most recommended to use by spring developers
    public Mainclass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructor Injection - Mainclass ");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }



    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }


}


@Configuration
@ComponentScan
public class DepedencyInject {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DepedencyInject.class);

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        System.out.println(context.getBean(Mainclass.class));

    }
}
