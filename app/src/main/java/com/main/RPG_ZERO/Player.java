package com.main.RPG_ZERO;

import com.raylib.Raylib.*;

public class Player {
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
}
