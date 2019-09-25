package io.github.elitedev.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerTeleportEvent;

public interface SpigotNPC extends NPC {

    Location getLocation();

    void setLocation(Location location);

    Entity getEntity();

    boolean isSpawned();

    void teleport(Location location);
}
