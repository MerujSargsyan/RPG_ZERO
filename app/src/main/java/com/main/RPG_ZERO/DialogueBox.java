package com.main.RPG_ZERO;

import static com.raylib.Jaylib.*;

public class DialogueBox {
    public boolean done = false;

    private String dialogue;
    private final int BOX_HEIGHT = 100;
    private final int BOX_WIDTH = App.WINDOW_WIDTH - 50;
    private final long CHAR_WAIT_TIME = 200l; 

    public void step(NPC ent) {
        dialogue = "";
        if(ent.isStreamFinished()) done = true;
        GuiMessageBox(new Rectangle(50, App.WINDOW_HEIGHT - BOX_HEIGHT - 50,
            BOX_WIDTH, BOX_HEIGHT), "TEST", dialogue, "");
        dialogue += ent.continueStream();

    }
}
