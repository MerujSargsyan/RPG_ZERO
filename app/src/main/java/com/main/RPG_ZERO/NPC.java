package com.main.RPG_ZERO;

public class NPC extends Obstacle {
    public String name;
    private String dialogue;
    private StringBuffer dialogueStream; 

    public NPC(float x, float y, int width, int height, 
        String name, String dialogue) {
        super(x, y, width, height);
        this.name = name;
        this.dialogue = dialogue;
        dialogueStream = new StringBuffer();
    }

    public String continueStream() {
        // temp
        return dialogue;
    }
}
