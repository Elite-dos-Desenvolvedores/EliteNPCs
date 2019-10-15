package io.github.elitedev.spigot.event.test;

import io.github.elitedev.spigot.entity.SpigotNPC;
import io.github.elitedev.spigot.entity.impl.SpigotNPCImpl_v1_8_R3;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

// Class for testing purposes only.
public class InteractEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Player player = event.getPlayer();
        Location location = event.getClickedBlock().getLocation();

        SpigotNPC npc = new SpigotNPCImpl_v1_8_R3(UUID.randomUUID(), location, "npc");
        npc.show(player);
    }

}
