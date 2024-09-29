package com.main.RPG_ZERO;

import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.BLACK;
import static com.raylib.Raylib.*;

public class NPC implements Entity {
    private Rectangle visibleRect;
    private Rectangle collisionRect;

    public NPC(float x, float y, float width, float height) {
        visibleRect = new Rectangle(x, y, width, height);
        collisionRect = visibleRect;
    }

    @Override
    public void draw() {
        DrawRectangleRec(visibleRect, BLACK);
    }
    
    @Override
    public Rectangle getCollisionRectangle() {
        return collisionRect;
    }
}
