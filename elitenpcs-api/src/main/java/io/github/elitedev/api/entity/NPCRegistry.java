package io.github.elitedev.api.entity;

import java.util.Optional;
import java.util.UUID;

public interface NPCRegistry {

    /**
     * Gets the {@link NPC} with the given unique id if it exists, otherwise null.
     *
     * @param uuid of the NPC
     * @return NPC with the given uuid
     */
    Optional<NPC> getByUuid(UUID uuid);

    /**
     * Gets the {@link NPC} with the given name if it exists, otherwise null.
     *
     * @param name of the NPC
     * @return NPC with the given name
     */
    Optional<NPC> getByName(String name);

    /**
     * Removes the {@link NPC} and removes all data about it from the data store.
     *
     * @param npc The NPC to unregister
     */
    void unregister(NPC npc);

    /**
     * Unregister all {@link NPC}s from this registry.
     * See also {@link #unregister(NPC)}
     */
    void unregisterAll();

}
