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
                CheckCollisionRecs(rect, collisionEntity.getCollisionRectangle())) {
                collisionObj = collisionEntity.getCollisionRectangle();
            }
        }

        return collisionObj == null;
    }

    // State return type is temporary
    public Entity getCollisionType(Rectangle rect) {
        ArrayList<Drawable> arr = graphicsM.getVisibleList();
        Entity collisionEntity = null;

        for(Drawable obj : arr) { 
            Entity curr = (Entity)obj;

            if(CheckCollisionRecs(rect, curr.getInteractioRectangle())) {
                collisionEntity = curr;
            }
        }

        return collisionEntity;
    }
}
