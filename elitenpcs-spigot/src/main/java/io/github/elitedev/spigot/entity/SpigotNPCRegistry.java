package io.github.elitedev.spigot.entity;

import io.github.elitedev.api.entity.NPCRegistry;

public interface SpigotNPCRegistry extends NPCRegistry {

    static SpigotNPCRegistry DEFAULT_IMPL () {
        return new SpigotNPCRegistryImpl();
    }
}
