package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;
import com.raylib.Jaylib.Rectangle;
import com.raylib.Jaylib.Vector2;
import static com.raylib.Jaylib.RED;
import static com.raylib.Jaylib.BLACK;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entities;
    private Interaction im;

    public EntityManager() {
        entities = new ArrayList<>();
        im = null;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
        if(entity instanceof Player) {
            Entity temp = entities.get(entities.size() - 1);
            entities.set(entities.size() - 1, entities.get(0));
            entities.set(0, temp);
        }
    }

    public void render() {
        entities.forEach((ent) -> ent.draw());
    }

    public boolean validateMovement(Vector2 vect) {
        Player player = (Player)entities.get(0);
        Rectangle currColl = player.getCollisionBox();

        Rectangle predictedColl = new Rectangle(currColl.x() + vect.x(), currColl.y() + vect.y(),
            currColl.width(), currColl.height());

        for(int i = 1; i < entities.size(); i++) {
            Rectangle entRect = entities.get(i).getCollisionBox();
            Entity obj = entities.get(i);

            if(CheckCollisionRecs(currColl, obj.getInteractionBox())) {
                obj.setColor(RED);
                if(im == null && IsKeyPressed(KEY_E)) {
                    im = new Interaction(obj);
                    im.startInteraction(obj);
                }
                if(im != null && im.active) im.processInteraction(obj);
            } else {
                obj.setColor(BLACK);
            }

            if(CheckCollisionRecs(predictedColl, entRect)) {
                return false;
            }
        }

        return true;
    }
}
