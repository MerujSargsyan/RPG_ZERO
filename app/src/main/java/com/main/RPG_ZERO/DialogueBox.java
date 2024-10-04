package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.WHITE;

public class DialogueBox implements Drawable {
    private final int BOX_HEIGHT = 100;
    private final int BOX_WIDTH = App.WINDOW_SIZE - 100;
    private final int OFFSET = 10;
    private String currentText;

    public DialogueBox() {
        currentText = "";
    };

    public void draw() {
        DrawRectangle(50, App.WINDOW_SIZE - 150, BOX_WIDTH, BOX_HEIGHT, BLACK);

        DrawText(currentText, 50 + OFFSET, App.WINDOW_SIZE - 150 + OFFSET, 12, WHITE);
    }

    public void updateText(char toAppend) {
        currentText += toAppend;
    }

    public void resetText() {
        currentText = "";
    }
}
