package io.github.elitedev.spigot.entity.impl;

import com.mojang.authlib.GameProfile;
import io.github.elitedev.spigot.entity.BaseNPC;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.UUID;

import static net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER;
import static net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER;

public class SpigotNPCImpl_v1_8_R3 extends BaseNPC {

    /**
     * Reference to avoid over casting.
     */
    private EntityPlayer entityPlayer;

    public SpigotNPCImpl_v1_8_R3(UUID uniqueId, Location location, String name) {
        super(uniqueId, location, name);
    }

    @Override
    protected Entity createEntity() {
        GameProfile gameProfile = new GameProfile(this.getUniqueId(), this.getName());

        // TODO: Add skin to game profile

        MinecraftServer server = MinecraftServer.getServer();
        WorldServer worldServer = ((CraftWorld) getLocation().getWorld()).getHandle();

        this.entityPlayer = new EntityPlayer(server, worldServer, gameProfile, new PlayerInteractManager(worldServer));

        this.entityPlayer.setLocation(
                getLocation().getX(),
                getLocation().getY(),
                getLocation().getZ(),
                getLocation().getYaw(),
                getLocation().getPitch()
        );

        return this.entityPlayer.getBukkitEntity();
    }

    @Override
    public void hide(Player player) {
        PlayerConnection playerConnection = ((CraftPlayer) player).getHandle().playerConnection;
        playerConnection.sendPacket(new PacketPlayOutPlayerInfo(REMOVE_PLAYER, entityPlayer));
    }

    @Override
    public void show(Player player) {
        PlayerConnection playerConnection = ((CraftPlayer) player).getHandle().playerConnection;
        playerConnection.sendPacket(new PacketPlayOutPlayerInfo(ADD_PLAYER, entityPlayer));
        playerConnection.sendPacket(new PacketPlayOutNamedEntitySpawn(entityPlayer));
    }

    @Override
    public void teleport(Location location) {
        this.entityPlayer.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }
}
