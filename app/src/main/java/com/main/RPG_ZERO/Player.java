package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import com.raylib.Jaylib.Vector2;
import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.ORANGE;

public class Player implements Drawable {
    public Vector2 pos;
    public Texture txt;
    public Rectangle collisionBox;
    public float speed;

    private final int PLAYER_SIZE = 50; 

    public Player(float x, float y) {
        pos = new Vector2(x, y);
        collisionBox = new Rectangle(x, y, PLAYER_SIZE, PLAYER_SIZE);
        speed = 7.0f;
        // drawTexture
    }

    // vec must be normalized
    public void updatePos(Vector2 vec) {
        // extract to different class CollisionManager
        /*Vector2 futurePos = new Vector2().x(pos.x() + vec.x()).y(pos.y() + vec.y());
        Rectangle xPotRect = collisionBox;
        xPotRect.x(collisionBox.x() + futurePos.x());*/

        pos.x(pos.x() + vec.x());
        pos.y(pos.y() + vec.y());
        collisionBox.x(pos.x()).y(pos.y());
    }

    @Override
    public void draw() {
        DrawRectangleV(pos, new Vector2(50, 50), ORANGE);
    }

    @Override
    public Rectangle getCollisionBox() {
        return collisionBox;
    }
}
