package io.github.elitedev.spigot.plugin;

import io.github.elitedev.api.NPCPlugin;
import io.github.elitedev.api.io.Storage;
import io.github.elitedev.spigot.event.test.InteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotNPCPlugin extends JavaPlugin implements NPCPlugin {

    @Override
    public Storage getStorage() {
        // TODO: Implement storage.
        return null;
    }

    @Override
    public void onEnable() {
        getLogger().info(getDescription().getFullName() + " enabled.");

        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
    }
}
