package com.learn.LooseCoupling;

public class RunApplication {
    public static void main(String[] args) {
        var mariogame = new Mario();

        //Dependency and wiring
        var gamerunner = new GameRunner(mariogame);

        gamerunner.run();
    }
}
