package io.github.elitedev.event;

import io.github.elitedev.entity.NPC;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NPCEvent extends Event {

   private static final HandlerList HANDLER_LIST = new HandlerList();

   private NPC npc;

   public NPCEvent(NPC npc) {
      this.npc = npc;
   }

   public NPC getNpc() {
      return npc;
   }

   @Override
   public HandlerList getHandlers() {
      return HANDLER_LIST;
   }

   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }
}
