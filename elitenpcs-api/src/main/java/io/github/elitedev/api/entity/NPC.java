package io.github.elitedev.api.entity;

import java.util.UUID;

public interface NPC {

    UUID getUniqueId();

    String getName();

    void setName(String name);

}
