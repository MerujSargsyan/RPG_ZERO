package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.BLACK;

import com.raylib.Jaylib.Rectangle;
import com.raylib.Jaylib.Vector2;;

public class Obstacle implements Drawable {
    public Vector2 pos;
    public Vector2 size;
    public Rectangle collisionBox;

    public Obstacle(float x, float y, int width, int height) {
        pos = new Vector2(x, y);
        size = new Vector2(width, height);
        collisionBox = new Rectangle(x, y, width, height);
    }

    @Override
    public void draw() {
        DrawRectangleV(pos, size, BLACK);
    }

    @Override
    public Rectangle getCollisionBox() {
        return collisionBox;
    }
}
