package com.main.RPG_ZERO;

public class Interaction {
    private Entity ent;
    private InteractionType type;

    private enum InteractionType {
        NONE,
        DIALOGUE,
        MERCHANT,
        COMBAT
    }

    public Interaction(Entity ent) {
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
    }

    public void processInteraction() {
        // TODO swich for this
        DialogueBox db = new DialogueBox((NPC)ent);
    }
}
