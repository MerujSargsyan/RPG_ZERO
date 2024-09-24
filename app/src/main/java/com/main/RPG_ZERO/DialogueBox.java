package com.main.RPG_ZERO;

import static com.raylib.Jaylib.*;

public class DialogueBox {
    public boolean done = false;

    private String dialogue;
    private final int BOX_HEIGHT = 100;
    private final int BOX_WIDTH = App.WINDOW_WIDTH - 50;

    public DialogueBox() {
        dialogue = "";
    }

    public void step(NPC ent) {
        if(ent.isStreamFinished()) done = true;
        GuiMessageBox(new Rectangle(50, App.WINDOW_HEIGHT - BOX_HEIGHT - 50,
            BOX_WIDTH, BOX_HEIGHT), "TEST", dialogue, "");
        dialogue += ent.continueStream();
    }

    public void resetDialogue(NPC ent) {
        dialogue = "";
        ent.resetDialogue();
    }

    public void flush(NPC ent) {
        while(!ent.isStreamFinished()) dialogue += ent.continueStream();
    }
}
