package io.github.elitedev.collections;

import io.github.elitedev.entity.NPC;

public class NpcNotValidException extends Exception {

    public NpcNotValidException() {
        super("NPC or NPC UUID cannot be null");
    }
}
