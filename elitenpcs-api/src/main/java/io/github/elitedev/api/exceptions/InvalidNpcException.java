package io.github.elitedev.api.exceptions;

public class InvalidNpcException extends Exception {

    public InvalidNpcException() {
        super("NPC or NPC UUID cannot be null");
    }
}
