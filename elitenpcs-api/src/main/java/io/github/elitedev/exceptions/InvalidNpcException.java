package io.github.elitedev.exceptions;

import io.github.elitedev.entity.NPC;

public class InvalidNpcException extends Exception {

    public InvalidNpcException() {
        super("NPC or NPC UUID cannot be null");
    }
}
