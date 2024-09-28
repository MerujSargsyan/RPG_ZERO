package com.main.RPG_ZERO;

import java.util.HashMap;
import java.util.ArrayList;

public class GraphicsManager {
    private HashMap<State, ArrayList<Drawable>> map;

    public GraphicsManager() {
        map = new HashMap<>();
        map.put(State.MOVING, new ArrayList<Drawable>());
        map.put(State.DIALOGUE, new ArrayList<Drawable>());
        map.put(State.INVENTORY, new ArrayList<Drawable>());
        map.put(State.COMBAT, new ArrayList<Drawable>());
    }

    public void addDrawable(Drawable obj, State state) {
        map.get(state).add(obj);
    }

    public void draw() {
        ArrayList<Drawable> arr = map.get(App.state);

        arr.forEach((obj) -> obj.draw());
    }
}