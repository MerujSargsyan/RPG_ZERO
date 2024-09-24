package com.main.RPG_ZERO;

import static com.raylib.Raylib.*;

public class Interaction {
    public boolean active = false;

    private Entity ent;
    private InteractionType type;
    private DialogueBox db;

    private enum InteractionType {
        NONE,
        DIALOGUE,
        MERCHANT,
        COMBAT
    }

    public Interaction(Entity ent) {
        
    }

    public void startInteraction(Entity ent) {
        this.ent = ent;
        active = true;

        if(ent instanceof Enemy) {
            type = InteractionType.COMBAT;
        } else if(ent instanceof NPC) {
            type = InteractionType.DIALOGUE;
        } else if(ent instanceof Merchant) {
            type = InteractionType.MERCHANT;
        } else {
            type = InteractionType.NONE;
        }

        // TODO: figure out how to structure this
        db = new DialogueBox();
        db.resetDialogue((NPC)ent);
    }

    public void processInteraction(Entity ent) {
        // TODO swich for this
        if(IsKeyDown(KEY_ENTER)) db.flush((NPC)ent);
        if(db.done && IsKeyPressed(KEY_ENTER)) {
            active = false;
        }
        db.step((NPC)ent);
    }
}
