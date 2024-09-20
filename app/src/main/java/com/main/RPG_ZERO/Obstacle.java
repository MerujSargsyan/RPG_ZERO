package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.YELLOW;

import com.raylib.Jaylib.Rectangle;
import com.raylib.Jaylib.Vector2;;

public class Obstacle implements Drawable {
    public Vector2 pos;
    public Vector2 size;
    public Rectangle collisionBox;
    public Rectangle interactionBox;

    private final int COLL_OFFSET = 10;
    private Color col;

    public Obstacle(float x, float y, int width, int height) {
        pos = new Vector2(x, y);
        size = new Vector2(width, height);
        collisionBox = new Rectangle(x - COLL_OFFSET, y - COLL_OFFSET,
            width + 2*COLL_OFFSET, height + 2*COLL_OFFSET);
        interactionBox = new Rectangle(x - 2*COLL_OFFSET, y - 2*COLL_OFFSET,
            width + 4*COLL_OFFSET, height + 4*COLL_OFFSET); 
        col = BLACK;

    }

    @Override
    public void draw() {
        DrawRectangleRec(interactionBox, YELLOW);
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

    @Override
    public Rectangle getInteractionBox() {
        return interactionBox;
    }
}
