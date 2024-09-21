package com.main.RPG_ZERO;

import com.raylib.Jaylib.Rectangle; 
import static com.raylib.Raylib.Color;

public interface Entity {
    public abstract Rectangle getCollisionBox();
    public abstract void setColor(Color c);
    public abstract Rectangle getInteractionBox();
    public abstract void draw();
}
