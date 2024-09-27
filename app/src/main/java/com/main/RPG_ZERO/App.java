package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib.Vector2;
import static com.raylib.Jaylib.WHITE;

public class App {
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;
    public static Camera2D camera;
    private EntityManager em;

    public App() {
        em = new EntityManager();

        Player p = new Player(WINDOW_WIDTH/2 - 25, WINDOW_HEIGHT/2 - 25);
        em.addEntity(p);

        camera = new Camera2D().target(p.getPos())
            .offset(p.getPos());
        camera.rotation(0.0f);
        camera.zoom(1.0f);

        Entity e1 = new NPC(0, 0, 200, 100, "BOT 1",
            "Hanging off mywasteline is a rock, pow pow! , I don't throw no bottbles I throw shots!\n" +
                "this is testing what happens if I have a lot of text in this text box ideally\n" +
                "It shold wrap around and fit within the box but God knows");
        em.addEntity(e1);
        NPC o2 = new NPC(WINDOW_HEIGHT, WINDOW_WIDTH, 100, 100, "BOT 2", "I just say\n HELLO WORLD!");
        em.addEntity(o2);

        InitWindow(WINDOW_WIDTH, WINDOW_HEIGHT, "Hello World!");
        SetTargetFPS(30);

        while(!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(WHITE);
            BeginMode2D(camera);
            em.render();
            parseInput(p);
            EndMode2D();
            EndDrawing();
        }
        CloseWindow();
    }

    private void parseInput(Player p) {
        if(IsKeyPressed(KEY_I) && p.state == State.MOVING) {
            p.state = State.INVENTORY;
            p.showInventory();
        } else if(IsKeyPressed(KEY_I) && p.state == State.INVENTORY) {
            p.state = State.MOVING;
        } else if(p.state == State.INVENTORY) {
            p.showInventory();
        }

        Vector2 movement = new Vector2();
        if(IsKeyDown(KEY_D)) movement.x(1 * p.speed);
        if(IsKeyDown(KEY_A)) movement.x(-1 * p.speed);
        if(IsKeyDown(KEY_W)) movement.y(-1 * p.speed);
        if(IsKeyDown(KEY_S)) movement.y(1 * p.speed);

        Vector2Normalize(movement);
        if(em.validateMovement(movement)) {
            if(p.state != State.MOVING) return;
            p.updatePos(movement);
            camera.target(p.getPos());
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
