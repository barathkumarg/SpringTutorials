package com.annonators.lazyloading;

import com.exercise.ExampleSpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class ClassA {

}

//this class can be loaded when it tend to be used, lazyy loaded
@Component
@Lazy
class ClassB {

    @SuppressWarnings("unused")
    private ClassA classA;

    public ClassB(ClassA classA) {
        //Logic
        System.out.println("Some Initialization logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do Something");
    }

}



@Configuration
@ComponentScan
public class SpringApplicationContext {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringApplicationContext.class);

        //get the component
        System.out.println("Initialization of context is completed");

        context.getBean(ClassB.class).doSomething();

    }


}
