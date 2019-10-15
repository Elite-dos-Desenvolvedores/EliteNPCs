package io.github.elitedev.api.collections;

import io.github.elitedev.api.entity.NPC;
import io.github.elitedev.api.exceptions.InvalidNpcException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryNpcMap implements NpcMap {

    private Map<UUID, NPC> npcs;

    public InMemoryNpcMap() {
        npcs = new HashMap<>();
    }

    @Override
    public NPC get(UUID uuid) {
        return npcs.get(uuid);
    }

    @Override
    public void put(UUID uuid, NPC npc) throws InvalidNpcException {
        if (npc == null || uuid == null) {
            throw new InvalidNpcException();
        }

        npcs.put(uuid, npc);
    }

    @Override
    public void remove(NPC npc) throws InvalidNpcException {
        if (npc == null || get(npc.getUniqueId()) == null) {
            throw new InvalidNpcException();
        }

        npcs.remove(npc.getUniqueId());
    }

    @Override
    public void removeAll() {
        npcs.clear();
    }

    @Override
    public Iterable<NPC> all() {
        return npcs.values();
    }
}
