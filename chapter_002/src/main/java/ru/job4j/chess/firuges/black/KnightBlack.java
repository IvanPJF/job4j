package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 11.10.2018
 * @since 0.1
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = Math.abs(source.x - dest.x);
        int deltaY = Math.abs(source.y - dest.y);
        if (!(deltaX == 1 && deltaY == 2 || deltaX == 2 && deltaY == 1)) {
            throw new ImpossibleMoveException("Сюда нельзя! (Конь)");
        }
        return new Cell[] {Cell.values()[dest.x * 8 + dest.y]};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}