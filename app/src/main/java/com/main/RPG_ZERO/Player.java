package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.BLACK;

public class Player implements Drawable {
    public Vector2 pos;
    public Texture txt;
    public float speed;

    public Player(float x, float y) {
        pos = new Vector2().x(x).y(y);
        speed = 5.0f;
        // drawTexture
    }

    // vec must be normalized
    public void updatePos(Vector2 vec) {
        pos.x(pos.x() + vec.x());
        pos.y(pos.y() + vec.y());
    }

    @Override
    public void draw() {
        DrawRectangleV(pos, new Vector2().x(50).y(50), BLACK);
    }
}
