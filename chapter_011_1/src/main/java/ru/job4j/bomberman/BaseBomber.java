package ru.job4j.bomberman;

/**
 * Abstract class BomberMan.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 16.12.2019
 */
public abstract class BaseBomber implements IBomber {

    private final Cell pos = new Cell();
    private final Cell tryWay = new Cell();

    /**
     * Returns the current bomberman position on the board.
     *
     * @return
     */
    @Override
    public Cell getPosition() {
        return this.pos;
    }

    /**
     * Sets the position of the bomberman on the board.
     *
     * @param newPosition
     */
    @Override
    public void setPosition(final Cell newPosition) {
        this.pos.setX(newPosition.getX());
        this.pos.setY(newPosition.getY());
    }

    /**
     * Offers a cell for the next move.
     * The choice of direction for the move is set in the {@link #choiceWay} method.
     *
     * @return
     */
    @Override
    public Cell step() {
        Cell cellWay = choiceWay().getCell();
        this.tryWay.setX(this.pos.getX() + cellWay.getX());
        this.tryWay.setY(this.pos.getY() + cellWay.getY());
        return this.tryWay;
    }
}
