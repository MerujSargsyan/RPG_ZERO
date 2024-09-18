package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.WHITE;

import java.util.ArrayList;

public class App {
    private ArrayList<Drawable> drawables;

    public App() {
        drawables = new ArrayList<>();

        Player p = new Player(225, 225);
        drawables.add(p);

        Obstacle o = new Obstacle(0, 0, 200, 100);
        drawables.add(o);

        InitWindow(500, 500, "Hello World!");
        SetTargetFPS(30);

        while(!WindowShouldClose()) {
            BeginDrawing();
            parseInput(p);
            drawSprites();
            ClearBackground(WHITE);
            EndDrawing();
        }
        CloseWindow();
    }

    public void drawSprites() {
        drawables.forEach((sprite) -> {
            sprite.draw();
        });
    }

    private void parseInput(Player p) {
        Vector2 movement = new Vector2();
        if(IsKeyDown(KEY_D)) movement.x(1 * p.speed);
        if(IsKeyDown(KEY_A)) movement.x(-1 * p.speed);
        if(IsKeyDown(KEY_W)) movement.y(-1 * p.speed);
        if(IsKeyDown(KEY_S)) movement.y(1 * p.speed);

        Vector2Normalize(movement);
        p.updatePos(movement);
    }

    public static void main(String[] args) {
        new App();
    }
}
