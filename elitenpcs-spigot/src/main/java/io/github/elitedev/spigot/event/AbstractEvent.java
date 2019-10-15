package io.github.elitedev.spigot.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

abstract class AbstractEvent extends Event {

    private HandlerList handlerList;

    AbstractEvent() {
        handlerList = new HandlerList();
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
