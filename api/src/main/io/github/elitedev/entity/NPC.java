package io.github.elitedev.entity;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.UUID;

public interface NPC {

  UUID getUniqueId();

  String getName();

  void setName(String name);

  Location getSpawnLocation();

  void setSpawnLocation(Location location);

  Location getLocation();

  void teleport(Location location);

  EntityType getEntityType();

  void setEntityType(EntityType entityType);

}
