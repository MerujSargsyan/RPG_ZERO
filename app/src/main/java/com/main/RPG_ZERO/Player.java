package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.BLACK;

public class Player implements Drawable {
    public Vector2 pos;
    public Texture txt;
    public Rectangle collisionBox;
    public float speed;

    private final int PLAYER_SIZE = 50; 

    public Player(float x, float y) {
        pos = new Vector2().x(x).y(y);
        collisionBox = new Rectangle().x(x).y(y).width(PLAYER_SIZE).height(PLAYER_SIZE);
        speed = 7.0f;
        // drawTexture
    }

    // vec must be normalized
    public void updatePos(Vector2 vec) {
        // extract to different class CollisionManager
        Vector2 futurePos = new Vector2().x(pos.x() + vec.x()).y(pos.y() + vec.y());
        Rectangle xPotRect = collisionBox;
        xPotRect.x(collisionBox.x() + futurePos.x());
    }

    @Override
    public void draw() {
        DrawRectangleV(pos, new Vector2().x(50).y(50), BLACK);
    }
}
