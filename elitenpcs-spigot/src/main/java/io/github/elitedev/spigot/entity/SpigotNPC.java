package io.github.elitedev.spigot.entity;

import io.github.elitedev.api.entity.NPC;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface SpigotNPC extends NPC {

    Location getLocation();

    void setLocation(Location location);

    Entity getEntity();

    boolean isSpawned();

    void teleport(Location location);

    void hide(Player player);

    void show(Player player);
}
