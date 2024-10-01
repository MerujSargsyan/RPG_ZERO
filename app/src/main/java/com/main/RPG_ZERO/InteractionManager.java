package com.main.RPG_ZERO;

public class InteractionManager {   
    public boolean isActive;

    private Entity[] entities;
    private Interaction interaction;

    public InteractionManager() {
        isActive = false;
    }

    //entities which will interact
    public void beginInteraction(Entity[] arr, State state) {
        if(isActive) return;

        entities = arr;
        beginInteraction(state);
    }

    public void step() {
        if(isActive && interaction != null) {
            interaction.step();
            if(interaction.finished()) isActive = false;
        }
    }

    private void beginInteraction(State state) {
        isActive = true;
        App.state = state;
        switch(state) {
            case DIALOGUE:
                initDialogue(entities[0]);
                break;
            case COMBAT:
                initCombat();
                break;
            case INVENTORY:
                initInventory();
                break;
            default:
                return;
        }
    }

    public void parseInput(int key) {
        if(interaction == null || !isActive) return;
        interaction.parseInput(key);
    }

    private void initDialogue(Entity e) {
        interaction = new DialogueInteraction((NPC)e);
    }

    private void initCombat() {

    }

    private void initInventory() {};
    
}
