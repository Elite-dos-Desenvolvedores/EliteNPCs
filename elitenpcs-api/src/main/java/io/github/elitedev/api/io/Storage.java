package io.github.elitedev.api.io;


import io.github.elitedev.api.entity.NPC;
import io.github.elitedev.api.entity.NPCRegistry;

/**
 * Represents a metadata storage to allow
 * the insertion / query of {@link NPC} details into/from some I/O storage.
 */
public interface Storage {

    /**
     * Clear the data of a given {@link NPC] from storage.
     *
     * @param npc The NPC to clear data from.
     */
    void clear(NPC npc);

    /**
     * Clear all {@link NPC} data that a registry contains from the storage.
     *
     * @param registry The registry to clear the NPCs from.
     */
    void clearAll(NPCRegistry registry);

    /**
     * Load all the npc data from a storage into the npc registry.
     *
     * @param registry The registry to load the NPCs from.
     */
    void load(NPCRegistry registry);

    /**
     * Notifies (or store in case of immediate mode) the storage to save all to disk.
     *
     * @param operationMode The operation mode is the way that the save will be executed
     *                      ({@link StorageOperationMode#ASYNC} or {@link StorageOperationMode#IMMEDIATE})
     */
    void save(StorageOperationMode operationMode);

    /**
     * Store a given {@link NPC} into the storage
     * Called from the {@link NPCRegistry}.
     *
     * @param npc The NPC to store into the storage.
     */
    void store(NPC npc);

    /**
     * Store all npcs from the registry into the storage.
     *
     * @param registry The registry to store the NPCs from.
     */
    void storeAll(NPCRegistry registry);

    /**
     * Reloads the storage.
     */
    void reloadFromSource();
}
