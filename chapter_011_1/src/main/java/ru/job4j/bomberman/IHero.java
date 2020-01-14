package ru.job4j.bomberman;

/**
 * BomberMan interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 16.12.2019
 */
public interface IHero {

    IHero createNewInstance();

    /**
     * Returns the current bomberman position on the board.
     *
     * @return
     */
    Cell getPosition();

    /**
     * Sets the position of the bomberman on the board.
     *
     * @param newPosition
     */
    void setPosition(final Cell newPosition);

    /**
     * Offers a cell for the next move.
     *
     * @return
     */
    Cell step(Way way);
}
