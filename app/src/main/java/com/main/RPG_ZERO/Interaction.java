package com.main.RPG_ZERO;

public interface Interaction {
    public abstract void step();
    public abstract void start();
    public abstract void parseInput(int key);
    public abstract void end();
    public abstract boolean finished();
}
