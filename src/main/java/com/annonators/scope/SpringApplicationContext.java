package com.annonators.scope;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class ClassA {

}

//this class can be loaded when it tend to be used, lazyy loaded
@Component
class ClassB {


}



@Configuration
@ComponentScan
public class SpringApplicationContext {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringApplicationContext.class);

        //get the component
        System.out.println("Initialization of context is completed");


        //This 2 output will be same as it treated Singleton
        System.out.println(context.getBean(ClassB.class));
        System.out.println(context.getBean(ClassB.class));

        //Treated as Prototype different objects created
        System.out.println(context.getBean(ClassA.class));
        System.out.println(context.getBean(ClassA.class));

    }


}
