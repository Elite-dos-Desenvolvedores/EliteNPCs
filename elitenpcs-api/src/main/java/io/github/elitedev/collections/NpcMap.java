package io.github.elitedev.collections;

import io.github.elitedev.entity.NPC;
import io.github.elitedev.exceptions.InvalidNpcException;

import java.util.UUID;

public interface NpcMap {

    NPC get(UUID uuid);

    void put(UUID uuid, NPC npc) throws InvalidNpcException;

    void remove(NPC npc) throws InvalidNpcException;

    void removeAll();

    Iterable<NPC> all();
}
