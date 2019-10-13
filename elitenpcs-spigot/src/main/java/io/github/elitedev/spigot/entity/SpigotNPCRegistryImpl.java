package io.github.elitedev.spigot.entity;

import io.github.elitedev.api.collections.InMemoryNpcMap;
import io.github.elitedev.api.collections.NpcMap;
import io.github.elitedev.api.entity.NPC;
import io.github.elitedev.api.exceptions.InvalidNpcException;

import java.util.Optional;
import java.util.UUID;

public class SpigotNPCRegistryImpl implements SpigotNPCRegistry {

    private NpcMap npcMap;

    public SpigotNPCRegistryImpl() {
        npcMap = new InMemoryNpcMap();
    }

    @Override
    public Optional<NPC> getByUuid(UUID uuid) {
        return Optional.ofNullable(npcMap.get(uuid));
    }

    @Override
    public Optional<NPC> getByName(String name) {
        NPC found = null;
        
        for(NPC npc : npcMap.all()){
           if(npc == null){
               return Optional.empty();
           }
           
           if(npc.getName().equalsIgnoreCase(name)){
               found = npc;
           }
        }

        return Optional.ofNullable(found);
    }

    @Override
    public void unregister(NPC npc) {
        try {
            npcMap.remove(npc);
        } catch (InvalidNpcException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unregisterAll() {
        npcMap.removeAll();
    }
    
}
