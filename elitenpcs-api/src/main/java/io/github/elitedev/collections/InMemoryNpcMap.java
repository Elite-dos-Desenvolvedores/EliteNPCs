package io.github.elitedev.collections;

import io.github.elitedev.entity.NPC;

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
    public void put(UUID uuid, NPC npc) {
        npcs.put(uuid, npc);
    }

    @Override
    public void remove(NPC npc) throws NpcNotValidException {
        if (npc == null || get(npc.getUniqueId()) == null) {
            throw new NpcNotValidException();
        }

        npcs.remove(npc.getUniqueId());
    }
}
