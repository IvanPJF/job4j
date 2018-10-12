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
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int wayX = source.x - dest.x;
        int wayY = source.y - dest.y;
        int deltaX = Math.abs(wayX);
        int deltaY = Math.abs(wayY);
        if (!(deltaX == 0 || deltaY == 0 || deltaX == deltaY)) {
            throw new ImpossibleMoveException("Сюда нельзя! (Ферзь)");
        }
        Cell[] result = new Cell[deltaX == deltaY ? deltaX : deltaX + deltaY];
        int stepX = Integer.compare(0, wayX);
        int stepY = Integer.compare(0, wayY);
        int i, j;
        for (int index = 0; index < result.length; index++) {
            i = source.x + stepX * (index + 1);
            j = source.y + stepY * (index + 1);
            result[index] = Cell.values()[i * 8 + j];
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}