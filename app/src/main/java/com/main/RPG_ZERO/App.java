package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib.Vector2;
import static com.raylib.Jaylib.WHITE;

public class App {
    private int WINDOW_WIDTH = 500;
    private int WINDOW_HEIGHT = 500;
    private Camera2D camera;
    private EntityManager em;

    public App() {
        em = new EntityManager();

        Player p = new Player(WINDOW_WIDTH/2 - 25, WINDOW_HEIGHT/2 - 25);
        em.addEntity(p);

        camera = new Camera2D().target(p.pos)
            .offset(p.pos);
        camera.rotation(0.0f);
        camera.zoom(1.0f);

        Obstacle o = new Obstacle(0, 0, 200, 100);
        em.addEntity(o);
        Obstacle o2 = new Obstacle(WINDOW_HEIGHT, WINDOW_WIDTH, 100, 100);
        em.addEntity(o2);

        InitWindow(WINDOW_WIDTH, WINDOW_HEIGHT, "Hello World!");
        SetTargetFPS(30);

        while(!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(WHITE);
            parseInput(p);
            BeginMode2D(camera);
            em.render();
            EndMode2D();
            EndDrawing();
        }
        CloseWindow();
    }

    private void parseInput(Player p) {
        Vector2 movement = new Vector2();
        if(IsKeyDown(KEY_D)) movement.x(1 * p.speed);
        if(IsKeyDown(KEY_A)) movement.x(-1 * p.speed);
        if(IsKeyDown(KEY_W)) movement.y(-1 * p.speed);
        if(IsKeyDown(KEY_S)) movement.y(1 * p.speed);

        Vector2Normalize(movement);
        if(em.validateMovement(movement)) {
            p.updatePos(movement);
            camera.target(p.pos);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
