package ru.job4j.bomberman;

/**
 * BomberMan interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 16.12.2019
 */
public interface IBomber {

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
     * The choice of direction for the move is set in the {@link #choiceWay} method.
     *
     * @return
     */
    Cell step();

    /**
     * The choice of direction for the move.
     * The result of choosing the direction of the path should be used in the method {@link #step}.
     *
     * @return
     */
    Way choiceWay();
}
