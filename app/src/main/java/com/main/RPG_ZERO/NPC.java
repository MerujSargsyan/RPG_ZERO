package com.main.RPG_ZERO;

// dialogue acts like an itterator
public class NPC extends Obstacle {
    public String name;
    private String dialogue;
    private int curr;

    public NPC(float x, float y, int width, int height, 
        String name, String dialogue) {
        super(x, y, width, height);
        this.name = name;
        this.dialogue = dialogue;
        curr = 0; // start at 0th index of string
    }

    public char continueStream() {
        if(curr < dialogue.length()) {
            return dialogue.charAt(curr++);
        }

        return '\0';
    }

    public boolean isStreamFinished() {
        return curr >= dialogue.length();
    }
}
