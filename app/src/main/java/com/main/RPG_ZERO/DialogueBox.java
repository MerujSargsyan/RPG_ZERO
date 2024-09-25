package com.main.RPG_ZERO;

import static com.raylib.Jaylib.*;

public class DialogueBox {
    public boolean done = false;

    private String dialogue;
    private final int BOX_HEIGHT = 100;
    private final int BOX_WIDTH = App.WINDOW_WIDTH - 50;
    private Vector2 playerPos;

    public DialogueBox(Vector2 playerPos) {
        dialogue = "";
        this.playerPos = playerPos;
    }

    private void drawWindow() {
        Rectangle outerRec = new Rectangle(25, App.WINDOW_HEIGHT - BOX_HEIGHT - 25,
            BOX_WIDTH, BOX_HEIGHT);
        Rectangle titleRec = new Rectangle(25, App.WINDOW_HEIGHT - BOX_HEIGHT - 25,
            BOX_WIDTH, 50);

        DrawRectangleRec(outerRec, BLACK);
        DrawRectangleLinesEx(titleRec, 5.0f, YELLOW);

        DrawText(dialogue, (int)outerRec.x(), (int)outerRec.y() + 55, 12, WHITE);
    }

    public void step(NPC ent) {
        if(ent.isStreamFinished()) done = true;
        drawWindow();
        //GuiMessageBox(new Rectangle(50, App.WINDOW_HEIGHT - BOX_HEIGHT - 50,
        //    BOX_WIDTH, BOX_HEIGHT), "TEST", dialogue, "");
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
