package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import com.raylib.Jaylib.Vector2;
import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.BLUE;
import static com.raylib.Jaylib.RED;

public class Player implements Drawable {
    private Vector2 pos;
    private Rectangle collisionBox;
    private final int COLL_OFFSET = 1;
    public Texture txt;
    public float speed;

    private final int PLAYER_SIZE = 50; 

    public Player(float x, float y) {
        pos = new Vector2(x, y);
        collisionBox = new Rectangle(x - PLAYER_SIZE/2, y - PLAYER_SIZE/2, 
            PLAYER_SIZE + COLL_OFFSET, PLAYER_SIZE + COLL_OFFSET);
        speed = 7.0f;
        // drawTexture
    }

    // vec must be normalized
    public void updatePos(Vector2 vec) {
        pos.x(pos.x() + vec.x());
        pos.y(pos.y() + vec.y());
        collisionBox.x(pos.x()).y(pos.y());
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 vect) {
        pos = vect;

        collisionBox = new Rectangle(pos.x() - PLAYER_SIZE/2, pos.y() - PLAYER_SIZE/2, 
            PLAYER_SIZE + COLL_OFFSET, PLAYER_SIZE + COLL_OFFSET);
    }

    @Override
    public void draw() {
        DrawRectangleRec(collisionBox, RED);
        DrawRectangleV(pos, new Vector2(50, 50), BLUE);
    }

    @Override
    public Rectangle getCollisionBox() {
        return collisionBox;
    }
}
