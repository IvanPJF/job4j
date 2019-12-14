package ru.job4j.bomberman;

/**
 * Class enum Way.
 * To indicate the direction of movement.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 16.12.2019
 */
public enum Way {

    UP(new Cell(0, -1)),
    DOWN(new Cell(0, 1)),
    LEFT(new Cell(-1, 0)),
    RIGHT(new Cell(1, 0));

    private final Cell cell;

    Way(Cell cell) {
        this.cell = cell;
    }

    Cell getCell() {
        return this.cell;
    }
}
