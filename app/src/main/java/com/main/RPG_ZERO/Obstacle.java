package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.BLACK;

import com.raylib.Jaylib.Rectangle;
import com.raylib.Jaylib.Vector2;;

public class Obstacle implements Drawable {
    public Vector2 pos;
    public Vector2 size;
    public Rectangle collisionBox;

    private final int COLL_OFFSET = 10;
    private Color col;

    public Obstacle(float x, float y, int width, int height) {
        pos = new Vector2(x, y);
        size = new Vector2(width, height);
        collisionBox = new Rectangle(x - COLL_OFFSET, y - COLL_OFFSET,
            width + 2*COLL_OFFSET, height + 2*COLL_OFFSET);
        col = BLACK;
    }

    @Override
    public void draw() {
        DrawRectangleV(pos, size, col);
    }

    @Override
    public void setColor(Color c) {
        col = c;
    }

    @Override
    public Rectangle getCollisionBox() {
        return collisionBox;
    }
}
