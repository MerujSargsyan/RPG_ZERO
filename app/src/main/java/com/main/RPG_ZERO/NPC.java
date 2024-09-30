package com.main.RPG_ZERO;

import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.RED;

import static com.raylib.Raylib.*;

public class NPC implements Entity {
    private Rectangle visibleRect;
    private Rectangle collisionRect;
    private Rectangle interactionRect;

    public NPC(float x, float y, float width, float height) {
        visibleRect = new Rectangle(x, y, width, height);
        collisionRect = visibleRect;
        interactionRect = new Rectangle(x, y, width + 10, height + 10);
    }

    @Override
    public void draw() {
        DrawRectangleRec(collisionRect, RED);
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
