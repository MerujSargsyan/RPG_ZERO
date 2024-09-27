package com.main.RPG_ZERO;

import java.util.ArrayList;

import com.raylib.Jaylib.Rectangle;
import static com.raylib.Jaylib.BLACK;

import static com.raylib.Raylib.*;

public class Inventory {
    private ArrayList<Item> items;
    private Rectangle rect;

    public Inventory(float startX, float startY) {
        items = new ArrayList<>();

        rect = new Rectangle(startX - App.WINDOW_WIDTH/2 + 50, startY - App.WINDOW_HEIGHT/2 + 50, 
            App.WINDOW_HEIGHT - 50, App.WINDOW_WIDTH - 50);
    }

    public void showInventory() {
        DrawRectangleRec(rect, BLACK);
    }

    public void updatePos(float x, float y) {
        rect.x(x - App.WINDOW_WIDTH/2 + 50).y(y - App.WINDOW_HEIGHT/2 + 50);
    }
}
