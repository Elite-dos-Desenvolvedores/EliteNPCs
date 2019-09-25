package io.github.elitedev.event;

import io.github.elitedev.entity.NPC;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;

public class NPCTeleportEvent extends AbstractEvent implements Cancellable {

    private NPC npc;
    private Location location;

    private boolean cancelled;

    public NPCTeleportEvent(NPC npc, Location location) {
        this.npc = npc;
        this.location = location;
    }

    public NPC getNpc() {
        return npc;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }
}
