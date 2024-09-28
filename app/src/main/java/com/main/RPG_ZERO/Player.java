package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib.Vector2;
import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.BLUE;
import static com.raylib.Jaylib.YELLOW;

public class Player implements Entity {
    public Vector2 position;
    public int speed;

    private Rectangle collisionRect;
    private final int PLAYER_SIZE = 50;

    public Player() {
        position = new Vector2((App.WINDOW_SIZE - PLAYER_SIZE)/2, 
            (App.WINDOW_SIZE - PLAYER_SIZE)/2);
        collisionRect = new Rectangle(position.x() - 10, position.y() - 10,
            70, 70);
        speed = 7;
    }

    public void updatePosition(Vector2 vect) {
        position = App.rayVectorToJayVector(Vector2Add(position, vect));
        collisionRect.x(position.x() - 10).y(position.y() - 10);
    }

    @Override
    public void draw() {
        DrawRectangleRec(collisionRect, YELLOW);
        DrawRectangle((int)position.x(), (int)position.y(), PLAYER_SIZE, PLAYER_SIZE, BLUE);
    }

    @Override
    public Rectangle getCollisioRectangle() {
        return collisionRect;
    }
} 