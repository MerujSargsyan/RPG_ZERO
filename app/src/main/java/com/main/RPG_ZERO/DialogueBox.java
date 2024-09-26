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
        // TODO: use camera settings to fit rectangle
        Vector2 offset = new Vector2(App.camera.offset().x(), App.camera.offset().y());
        float x = offset.x() - App.WINDOW_WIDTH/3 - 25;
        float y = offset.y() + App.WINDOW_WIDTH/4;

         Rectangle outerRec = new Rectangle(x, y, BOX_WIDTH, BOX_HEIGHT);
        Rectangle titleRec = new Rectangle(x, y, BOX_WIDTH, 50);

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
