package com.learn.LooseCoupling;

public class Mario implements GameConsole{


    @Override
    public void run() {
        System.out.println("Mario Run");
    }

    @Override
    public void moveleft() {
        System.out.println("Mario Move Left");

    }

    @Override
    public void moveright() {
        System.out.println("Mario Move Right");

    }

    @Override
    public void stop() {
        System.out.println("Mario Stop");
    }
}
