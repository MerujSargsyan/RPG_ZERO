package com.main.RPG_ZERO;

import com.raylib.Raylib.Rectangle; 

public interface Drawable {
    public abstract Rectangle getCollisionBox();
    public abstract void draw();
}
