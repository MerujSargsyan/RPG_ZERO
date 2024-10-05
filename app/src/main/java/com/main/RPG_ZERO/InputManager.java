package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib.Vector2;
import com.raylib.Jaylib.Rectangle;

public class InputManager {
    private final int INTERACT_KEY = KEY_E;
    private CollisionService collisionS; 
    private InteractionManager interactionM;

    public InputManager(CollisionService collisionS) {
        this.collisionS = collisionS;
        interactionM = new InteractionManager();
    } 

    private boolean validMovement(Vector2 vect) {
        Player p = App.player;
        Rectangle rect = p.getCollisionRectangle();

        Rectangle potential = new Rectangle(rect.x() + vect.x(), rect.y() + vect.y(),
            rect.width(), rect.height());

        return collisionS.checkCollision(potential);
    }

    @SuppressWarnings({"resource"})
    public void parseMovement() {
        Vector2 movement = new Vector2();
        Player player = App.player;

        if(IsKeyDown(KEY_D)) movement.x(1);
        if(IsKeyDown(KEY_A)) movement.x(-1);
        if(IsKeyDown(KEY_W)) movement.y(-1);
        if(IsKeyDown(KEY_S)) movement.y(1);
       
        movement = App.rayVectorToJayVector(
            Vector2Scale(Vector2Normalize(movement), player.speed)
        );
        if(!validMovement(movement)) return;
        player.updatePosition(movement);
    }

    public void parseInput(int key) {
        if(key == INTERACT_KEY && App.state == State.MOVING) {
            Entity e = collisionS.getCollisionType(App.player.getCollisionRectangle());
            if(e == null) return;
            if(!interactionM.isActive) interactionM.beginInteraction(new Entity[]{e}, State.DIALOGUE);
            return;
        }

        if(interactionM.isActive) interactionM.parseInput(key);
    }

    public void stepInteraction() {
        interactionM.step();
    }
}