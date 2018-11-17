package ru.job4j.generic;

public class ContainerIsFullException extends RuntimeException {

    public ContainerIsFullException(String msg) {
        super(msg);
    }
}
