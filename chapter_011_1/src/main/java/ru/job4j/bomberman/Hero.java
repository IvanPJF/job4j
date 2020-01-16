package ru.job4j.bomberman;

/**
 * Abstract class BomberMan.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 16.12.2019
 */
public class Hero implements IHero {

    private final Cell pos = new Cell();
    private final Cell tryWay = new Cell();

    @Override
    public IHero createNewInstance() {
        return new Hero();
    }

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
     *
     * @return
     */
    @Override
    public Cell step(Way way) {
        Cell cellWay = way.getCell();
        this.tryWay.setX(this.pos.getX() + cellWay.getX());
        this.tryWay.setY(this.pos.getY() + cellWay.getY());
        return this.tryWay;
    }
}
