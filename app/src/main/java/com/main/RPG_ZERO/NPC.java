package com.main.RPG_ZERO;

import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.BLACK;

import static com.raylib.Raylib.*;

public class NPC implements Entity {
    private Rectangle visibleRect;
    private Rectangle collisionRect;
    private Rectangle interactionRect;

    public String dialogue;
    private int currentChar;

    public NPC(float x, float y, float width, float height) {
        visibleRect = new Rectangle(x, y, width, height);
        collisionRect = visibleRect;
        interactionRect = new Rectangle(x - 10, y - 10, width + 20, height + 20);

        currentChar = 0;
        dialogue = "This is just a test if I can speed up the interaction by \n pressing ENTER";
    }

    public char nextChar() {
        if(currentChar >= dialogue.length()) return '\0';
        return dialogue.charAt(currentChar++);
    }

    public String getFinalDialogue() {
        return dialogue;
    }

    @Override
    public void draw() {
        DrawRectangleRec(visibleRect, BLACK);
    }
    
    @Override
    public Rectangle getCollisionRectangle() {
        return collisionRect;
    }

    @Override
    public Rectangle getInteractioRectangle() {
        return interactionRect;
    }
}
