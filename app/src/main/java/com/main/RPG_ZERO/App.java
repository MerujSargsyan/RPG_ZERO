package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.RAYWHITE;

public class App {
    //private GraphicsManager graphicsM;
    //private InputManager inputM;
    //private InteractionManager interactionM;

    public App() {
        // graphicsM = new GraphicsManager();
        // inputM = new InputManager();
        // interactionMM = new InteractionManager();

        InitWindow(500, 500, "RPG_ZERO");
        while(!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);
            EndDrawing();
        }
    }

    public static void main(String[] args) {
        new App();
    }
}