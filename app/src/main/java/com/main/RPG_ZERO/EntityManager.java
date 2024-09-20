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

    public boolean checkCollision(Rectangle rect) {
        // TODO: use spatial paritioning to speed this up
        for(int i = 1; i < entities.size(); i++) {
            Rectangle entRect = entities.get(i).getCollisionBox();
            if(CheckCollisionRecs(rect, entRect)) return true;
        }

        return false;
    }

    public boolean validateMovement(Vector2 vect) {
        Player player = (Player)entities.get(0);
        Rectangle currColl = player.getCollisionBox();
        Rectangle predictedColl = currColl.x(currColl.x() + vect.x()).y(currColl.y() + vect.y());
        
        return !checkCollision(predictedColl);
    }
}
