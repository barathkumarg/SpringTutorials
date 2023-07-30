package com.learn.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public GameConsole game(){
        return new Mario();
    }

    @Bean
    public GameRunner gamerunner(GameConsole game){
        return new GameRunner(game);
    }


}
