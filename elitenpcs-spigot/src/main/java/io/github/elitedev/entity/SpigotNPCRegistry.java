package io.github.elitedev.entity;

public interface SpigotNPCRegistry extends NPCRegistry {

    static SpigotNPCRegistry DEFAULT_IMPL () {
        return new SpigotNPCRegistryImpl();
    }
}
