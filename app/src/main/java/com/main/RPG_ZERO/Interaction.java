package com.main.RPG_ZERO;

public class Interaction {
    public static boolean active = false;

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

    private void startInteraction(Entity ent) {
        this.ent = ent;

        if(ent instanceof Enemy) {
            type = InteractionType.COMBAT;
        } else if(ent instanceof NPC) {
            type = InteractionType.DIALOGUE;
        } else if(ent instanceof Merchant) {
            type = InteractionType.MERCHANT;
        } else {
            type = InteractionType.NONE;
        }

        db = new DialogueBox();
    }

    public void processInteraction(Entity ent) {
        // TODO swich for this
        if(!active) {
            active = true;
            startInteraction(ent);
        } else {
            if(db.done) active = false;
            db.step((NPC)ent);
        }
    }
}
