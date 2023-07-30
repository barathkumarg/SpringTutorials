package com.learn;

import com.learn.Game.GameConsole;
import com.learn.Game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn.Game")
public class GameApplication {
    public static void main(String[] args) {

        //Declare the context
        var context = new AnnotationConfigApplicationContext(GameApplication.class);

        //get the game console - mario bean or instance --> Mario component
        context.getBean(GameConsole.class).up();

        //get the Game runner -> Complete game runner implementation, as it calls primary by default if multi component found
        context.getBean(GameRunner.class).run();

        //Qualifier explicitly mention the context to call the component
        context.getBean(GameRunner.class).run();

    }


}
