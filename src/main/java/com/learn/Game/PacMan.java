package com.learn.Game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacMan")
public class PacMan implements GameConsole{
    @Override
    public void up() {
        System.out.println(" Pacman Run");
    }

    @Override
    public void moveleft() {
        System.out.println("Pacman Move Left");

    }

    @Override
    public void moveright() {
        System.out.println("Pacman Move Right");

    }

    @Override
    public void stop() {
        System.out.println("Pacman Stop");
    }
}
