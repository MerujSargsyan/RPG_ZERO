package com.main.RPG_ZERO;

import com.raylib.Jaylib.Rectangle;

public class CollisionService {
    private GraphicsManager graphicsM;

    public CollisionService(GraphicsManager graphicsM) {
        this.graphicsM = graphicsM;
    }

    public boolean checkCollision(Rectangle rect) {
        return true;
    }
}
