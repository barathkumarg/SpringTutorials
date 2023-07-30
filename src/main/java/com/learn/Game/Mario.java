package com.learn.Game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Mario implements GameConsole{

    @Override
    public void up() {
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
