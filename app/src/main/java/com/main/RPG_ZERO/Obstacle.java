package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.BLACK;

public class Obstacle implements Entity {
    private Rectangle displayRect;
    private Rectangle collisionRect;

    public Obstacle(int x, int y, int width, int height) {
        displayRect = new Rectangle(x, y, width, height);
        collisionRect = new Rectangle(x, y, width, height);
    }

    @Override
    public Rectangle getCollisioRectangle() {
        return collisionRect;
    }

    @Override
    public void draw() {
        DrawRectangleRec(displayRect, BLACK);
    }
}
