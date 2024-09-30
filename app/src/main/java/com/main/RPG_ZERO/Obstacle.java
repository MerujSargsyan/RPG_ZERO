package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.RED;

public class Obstacle implements Entity {
    private Rectangle displayRect;
    private Rectangle collisionRect;

    public Obstacle(int x, int y, int width, int height) {
        displayRect = new Rectangle(x, y, width, height);
        collisionRect = new Rectangle(x, y, width + 10, height + 10);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return collisionRect;
    }

    @Override
    public void draw() {
        DrawRectangleRec(collisionRect, RED);
        DrawRectangleRec(displayRect, BLACK);
    }

    @Override
    public Rectangle getInteractioRectangle() {
        return null;
    }
}
