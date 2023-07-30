package com.learn.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GameBeans {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GameConfiguration.class);

        //get the bean from the configuration file and execution
        context.getBean(GameConsole.class).run();
    }

}
