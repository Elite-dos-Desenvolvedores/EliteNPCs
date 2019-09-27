package io.github.elitedev.entity;

import io.github.elitedev.collections.InMemoryNpcMap;
import io.github.elitedev.collections.NpcMap;
import io.github.elitedev.exceptions.InvalidNpcException;

import java.util.Optional;
import java.util.UUID;

public class SpigotNPCRegistryImpl implements SpigotNPCRegistry {

    private NpcMap npcMap;

    public SpigotNPCRegistryImpl() {
        npcMap = new InMemoryNpcMap();
    }

    @Override
    public Optional<NPC> getByUuid(UUID uuid) {
        NPC npc = npcMap.get(uuid);

        if(npc == null){
            return Optional.empty();
        }
        
        return Optional.of(npcMap.get(uuid));
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

        if(found == null){ //Just in case, lets defend ourselves
            return Optional.empty();
        }

        return Optional.of(found);
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
