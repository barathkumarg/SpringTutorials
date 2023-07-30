package com.learn.Game;

//loose coupling interface to make the depend class to other.

import org.springframework.stereotype.Component;


public interface GameConsole {

    void up();
    void moveleft();
    void moveright();
    void stop();
}
