package io.github.elitedev.entity;

import io.github.elitedev.event.NPCTeleportEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.UUID;

public abstract class BaseNPC implements SpigotNPC {

    private UUID uniqueId;
    private Location currentLocation;
    private Entity entity;

    private String name;

    public BaseNPC(UUID uniqueId, Location currentLocation, Entity entity, String name) {
        this.uniqueId = uniqueId;
        this.currentLocation = currentLocation;
        this.entity = entity;
        this.name = name;
    }

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
        this.currentLocation = location;
    }

    @Override
    public Location getLocation() {
        return currentLocation;
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
}
