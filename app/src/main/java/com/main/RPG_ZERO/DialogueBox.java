package com.main.RPG_ZERO;

import static com.raylib.Jaylib.*;

public class DialogueBox {
    private String dialogue;
    private final int BOX_HEIGHT = 100;
    private final int BOX_WIDTH = App.WINDOW_WIDTH - 50;

    public DialogueBox(NPC ent) {
        dialogue = ent.continueStream();
        GuiEnable();
        System.out.println(GuiGetState());
        GuiMessageBox(new Rectangle(50, App.WINDOW_HEIGHT - BOX_HEIGHT - 25,
          BOX_WIDTH, BOX_HEIGHT), "TEST", "Hello Test!", "");
    } 
}
