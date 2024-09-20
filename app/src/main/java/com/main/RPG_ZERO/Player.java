package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import com.raylib.Jaylib.Vector2;
import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.BLUE;

public class Player implements Drawable {
    private Vector2 pos;
    private Rectangle collisionBox;
    private Color col;

    public Texture txt;
    public float speed;

    private final int PLAYER_SIZE = 50; 

    public Player(float x, float y) {
        pos = new Vector2(x, y);
        collisionBox = new Rectangle(x - PLAYER_SIZE/2, y - PLAYER_SIZE/2, 
            PLAYER_SIZE, PLAYER_SIZE);
        speed = 7.0f;
        col = BLUE;
        // drawTexture
    }

    // vec must be normalized
    public void updatePos(Vector2 vect) {
        pos.x((pos.x() + vect.x()));
        pos.y((pos.y() + vect.y()));
        collisionBox.x(pos.x()).y(pos.y());
    }

    public void updatePosExact(Vector2 vect) {
        pos = vect;
        collisionBox.x(pos.x()).y(pos.y());
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 vect) {
        pos = vect;

        collisionBox = new Rectangle(pos.x() - PLAYER_SIZE/2, pos.y() - PLAYER_SIZE/2, 
            PLAYER_SIZE, PLAYER_SIZE);
    }

    @Override
    public void draw() {
        DrawRectangleV(pos, new Vector2(50, 50), col);
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
        return null;
    }
}
