package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib.Vector2;
import static com.raylib.Jaylib.BLUE;

public class Player implements Drawable {
    public Vector2 position;
    private final int PLAYER_SIZE = 50;

    public Player() {
        position = new Vector2((App.WINDOW_SIZE - PLAYER_SIZE)/2, 
            (App.WINDOW_SIZE - PLAYER_SIZE)/2);
    }

    @Override
    public void draw() {
        DrawRectangle((int)position.x(), (int)position.y(), PLAYER_SIZE, PLAYER_SIZE, BLUE);
    }
} 