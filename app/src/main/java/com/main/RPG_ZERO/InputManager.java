package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib.Vector2;

public class InputManager {
    private final int INTERACT_KEY = KEY_E;
    private final int[] MOVEMENT_KEYS = new int[]{KEY_W, KEY_D, KEY_S, KEY_A};

    public void parseInput(int keyInput) {
        if(keyInput == 0) return;
        Player player = App.player;
        Vector2 movement = new Vector2(0, 0);
        
        switch(keyInput) {
            case KEY_W:
                movement.y(-1);
                break;
            case KEY_S:
                movement.y(1);
                break;
            case KEY_A:
                movement.x(-1);
                break;
            case KEY_D:
                movement.x(1);
                break;
        }

        System.out.println("" + movement.x() + " " + movement.y());
        // Vector2Normalize(movement);
        Vector2 newVect = App.rayVectorToJayVector(Vector2Add(player.position, movement));
        player.position.x(newVect.x());
        player.position.y(newVect.y());
    }
}