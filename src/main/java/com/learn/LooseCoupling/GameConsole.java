package com.learn.LooseCoupling;

//loose coupling interface to make the depend class to other.
public interface GameConsole {

    void run();
    void moveleft();
    void moveright();
    void stop();
}
