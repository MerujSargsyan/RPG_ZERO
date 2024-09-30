package com.main.RPG_ZERO;

import com.raylib.Jaylib.Rectangle;

public interface Entity extends Drawable{
    public abstract Rectangle getCollisionRectangle();
    public abstract Rectangle getInteractioRectangle();
}
