package com.learn.LooseCoupling;

public class PacMan implements GameConsole{
    @Override
    public void run() {
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
