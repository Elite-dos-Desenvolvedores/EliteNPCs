package io.github.elitedev;

import io.github.elitedev.entity.NPC;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public interface SpigotNPC extends NPC {

    Location getSpawnLocation();

    void setSpawnLocation(Location location);

    Location getLocation();

    EntityType getEntityType();

    void setEntityType(EntityType entityType);
}
