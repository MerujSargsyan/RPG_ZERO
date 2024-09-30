package com.main.RPG_ZERO;

import java.util.HashMap;
import java.util.ArrayList;

public class GraphicsManager {
    private HashMap<State, ArrayList<Drawable>> map;
    private Player player;

    public GraphicsManager(Player player) {
        map = new HashMap<>();
        map.put(State.MOVING, new ArrayList<Drawable>());
        map.put(State.DIALOGUE, new ArrayList<Drawable>());
        map.put(State.INVENTORY, new ArrayList<Drawable>());
        map.put(State.COMBAT, new ArrayList<Drawable>());

        this.player = player;
    }

    public void addDrawable(Drawable obj, State state) {
        map.get(state).add(obj);
    }

    public void draw() {
        ArrayList<Drawable> arr = map.get(App.state);

        arr.forEach((obj) -> obj.draw());
        player.draw();
    }

    public ArrayList<Drawable> getVisibleList() {
        return map.get(App.state);
    }
}