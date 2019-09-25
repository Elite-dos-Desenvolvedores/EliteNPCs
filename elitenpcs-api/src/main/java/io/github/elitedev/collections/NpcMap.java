package io.github.elitedev.collections;

import io.github.elitedev.entity.NPC;

import java.util.UUID;

public interface NpcMap {

    NPC get(UUID uuid);

    void put(UUID uuid, NPC npc);

    void remove(NPC npc) throws NpcNotValidException;
}
