package com.main.RPG_ZERO;

import static com.raylib.Raylib.*; 

public class DialogueInteraction implements Interaction {
    private NPC npc;
    private String dialogue;
    private String finishedDialogue;

    public DialogueInteraction(NPC e) {
        npc = e;
        dialogue = "";
        finishedDialogue = e.dialogue;
    }

    @Override
    public void start() {
        // add interaction box
    }

    @Override
    public void step() {
        if(!finished()) dialogue += npc.nextChar();
        System.out.println(dialogue);
    }

    @Override
    public void end() {
        // remove interaction box
    }

    @Override 
    public void parseInput(int key) {
        if(key == KEY_ENTER) {
            while(dialogue.length() != finishedDialogue.length()) dialogue += npc.nextChar();
        }
    }

    @Override
    public boolean finished() {
        return dialogue.length() == finishedDialogue.length();
    }
}
