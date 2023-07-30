package com.learn.Game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GameConsole game;
    GameRunner(@Qualifier("PacMan") GameConsole game){
        this.game = game;
    }

    public void run(){
        game.up();
        game.moveleft();
        game.moveright();
        game.stop();
    }
}
