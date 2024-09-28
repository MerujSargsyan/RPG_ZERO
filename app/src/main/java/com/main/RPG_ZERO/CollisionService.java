package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import com.raylib.Jaylib.Rectangle;

import java.util.ArrayList;

public class CollisionService {
    private GraphicsManager graphicsM;

    public CollisionService(GraphicsManager graphicsM) {
        this.graphicsM = graphicsM;
    }

    public boolean checkCollision(Rectangle rect) {
        // NOTE: collision only happen with entities
        ArrayList<Drawable> arr = graphicsM.getVisibleList();
        Rectangle collisionObj = null;

        for(Drawable obj : arr) { 
            Entity collisionEntity = (Entity)obj;

            if(App.player != collisionEntity && 
                CheckCollisionRecs(rect, collisionEntity.getCollisioRectangle())) {
                collisionObj = collisionEntity.getCollisioRectangle();
            }
        }

        return collisionObj == null;
    }

    // State return type is temporary
    public State getCollisionType(Rectangle rect) {
        ArrayList<Drawable> arr = graphicsM.getVisibleList();
        Rectangle collisionObj = null;

        for(Drawable obj : arr) { 
            Entity collisionEntity = (Entity)obj;

            if(App.player != collisionEntity && 
                CheckCollisionRecs(rect, collisionEntity.getCollisioRectangle())) {
                collisionObj = collisionEntity.getCollisioRectangle();
            }
        }

        if(collisionObj == null) return App.state;
        // add other object instaces here
        // if(collisionObj instanceof NPC) return State.DIALOGUE;

        return null;
    }
}
