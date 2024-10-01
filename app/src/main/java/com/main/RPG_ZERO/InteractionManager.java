package com.main.RPG_ZERO;

public class InteractionManager {   

    public InteractionManager(Entity e) {
        if(e instanceof NPC) {
            App.state = State.DIALOGUE;
        }
    }
}
