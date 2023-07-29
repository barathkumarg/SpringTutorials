package com.learn.LooseCoupling;

public class GameRunner {
    private GameConsole game;
    GameRunner(GameConsole game){
        this.game = game;
    }

    public void run(){
        game.run();
        game.moveleft();
        game.moveright();
        game.stop();
    }
}
