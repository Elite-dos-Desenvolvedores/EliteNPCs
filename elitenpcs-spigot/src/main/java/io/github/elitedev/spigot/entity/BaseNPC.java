package io.github.elitedev.spigot.entity;

import io.github.elitedev.spigot.event.NPCTeleportEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.UUID;

public abstract class BaseNPC implements SpigotNPC {

    private UUID uniqueId;
    private Location location;
    private Entity entity;

    private String name;

    public BaseNPC(UUID uniqueId, Location location, String name) {
        this.uniqueId = uniqueId;
        this.location = location;
        this.name = name;

        Entity npc = createEntity();
        npc.teleport(location);
        setEntity(npc);
    }

    protected abstract Entity createEntity();

    @Override
    public void teleport(Location location) {
        if(!isSpawned()){
            return;
        }

        NPCTeleportEvent event = new NPCTeleportEvent(this, location);
        Bukkit.getPluginManager().callEvent(event);

        if(event.isCancelled()){
            return;
        }

        Entity entity = getEntity();
        entity.teleport(location);
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public boolean isSpawned() {
        return getEntity() != null && getEntity().isValid();
    }

    protected void setEntity(Entity entity) {
        this.entity = entity;
    }
}
