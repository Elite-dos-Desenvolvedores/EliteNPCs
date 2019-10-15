package io.github.elitedev.api.collections;

import io.github.elitedev.api.entity.NPC;
import io.github.elitedev.api.exceptions.InvalidNpcException;

import java.util.UUID;

public interface NpcMap {

    NPC get(UUID uuid);

    void put(UUID uuid, NPC npc) throws InvalidNpcException;

    void remove(NPC npc) throws InvalidNpcException;

    void removeAll();

    Iterable<NPC> all();
}
