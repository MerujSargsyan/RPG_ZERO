package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.RAYWHITE;

import com.raylib.Raylib;
import com.raylib.Jaylib;

public class App {
    public static State state = State.MOVING;
    public static int WINDOW_SIZE = 500;
    public static Player player = new Player();

    private GraphicsManager graphicsM;
    private InputManager inputM;
    private CollisionService collisionS;
    //private InteractionManager interactionM;

    public App() {
        graphicsM = new GraphicsManager();
        collisionS = new CollisionService(graphicsM);
        inputM = new InputManager(collisionS);
        //interactionMM = new InteractionManager();

        graphicsM.addDrawable(player, State.MOVING);
        graphicsM.addDrawable(player, State.DIALOGUE);
        addTestObjects();

        InitWindow(WINDOW_SIZE, WINDOW_SIZE, "RPG_ZERO");
        SetTargetFPS(30);

        while(!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);
            if(state == State.MOVING) inputM.parseMovement();
            graphicsM.draw();
            EndDrawing();
        }
    }

    public static Jaylib.Vector2 rayVectorToJayVector(Raylib.Vector2 vect) {
        return new Jaylib.Vector2(vect.x(), vect.y());
    }

    private void addTestObjects() {
        Entity o1 = new Obstacle(10, 10, 200, 100);
        graphicsM.addDrawable(o1, State.MOVING);
    }

    public static void main(String[] args) {
        new App();
    }
}