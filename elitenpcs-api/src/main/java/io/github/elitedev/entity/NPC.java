package io.github.elitedev.entity;

import java.util.UUID;

public interface NPC {

  UUID getUniqueId();

  String getName();

  void setName(String name);

}
