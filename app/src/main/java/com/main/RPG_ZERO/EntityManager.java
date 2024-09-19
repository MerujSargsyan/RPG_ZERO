package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Drawable> entities;
    private int playerIdx;

    public EntityManager() {
        entities = new ArrayList<>();
        playerIdx = -1;
    }

    public void addEntity(Drawable entity) {
        entities.add(entity);
        if(entity instanceof Player) {
            Drawable temp = entities.get(entities.size() - 1);
            entities.set(entities.size() - 1, entities.get(0));
            entities.set(0, temp);
            playerIdx = 0;
        }
    }

    public void render() {
        entities.forEach((ent) -> ent.draw());
    }

    public void handleCollision() {
        // TODO: use spatial paritioning to speed this up
        Player p = (Player)entities.get(playerIdx);
        for(int i = 1; i < entities.size(); i++) {
            Rectangle playerRect = p.getCollisionBox();
            Rectangle entRect = entities.get(i).getCollisionBox();
            System.out.println(CheckCollisionRecs(playerRect, entRect));
        }
    }
}
