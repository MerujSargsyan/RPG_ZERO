package com.main.RPG_ZERO;

import static com.raylib.Raylib.*; 

public class DialogueInteraction implements Interaction {
    private NPC npc;
    private String dialogue;
    private String finishedDialogue;
    private DialogueBox db;

    public DialogueInteraction(NPC e) {
        npc = e;
        dialogue = "";
        finishedDialogue = e.dialogue;
        db = new DialogueBox();

        start();
    }

    @Override
    public void start() {
        // add interaction box
        App.graphicsM.addDrawable(db, State.DIALOGUE);
    }

    @Override
    public void step() {
        if(!finished()) db.updateText(npc.nextChar());
    }

    @Override
    public void end() {
        // remove interaction box
    }

    @Override 
    public void parseInput(int key) {
        if(finished() && key == KEY_ENTER) {
            App.state = State.MOVING;
            return;
        }

        if(key == KEY_ENTER) {
            dialogue = finishedDialogue;
            db.resetText();
            db.setText(finishedDialogue);
        }
    }

    @Override
    public boolean finished() {
        return dialogue.length() == finishedDialogue.length();
    }
}
