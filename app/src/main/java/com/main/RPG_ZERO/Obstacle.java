package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.BLACK;

public class Obstacle implements Drawable {
    public Vector2 pos;
    public Vector2 size;
    public Vector2 collisionBox;

    public Obstacle(float x, float y, int width, int height) {
        pos = new Vector2().x(x).y(y);
        size = new Vector2().x(width).y(height);
    }

    @Override
    public void draw() {
        DrawRectangleV(pos, size, BLACK);
    }
}
