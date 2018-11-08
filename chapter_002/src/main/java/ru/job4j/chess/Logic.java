package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 09.10.2018
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Нет фигуры");
        }
        boolean rst = false;
        Cell[] steps = this.figures[index].way(source, dest);
        Arrays.stream(this.figures).filter(
                figure -> Arrays.stream(steps).anyMatch(step -> figure.position().equals(step))
        ).forEach(figure -> {
            throw new OccupiedWayException("Путь не свободен.");
        });
        if (steps.length > 0) {
            this.figures[index] = this.figures[index].copy(dest);
            rst = true;
        }
        return rst;
    }

    public void clean() {
        IntStream.range(0, this.figures.length).forEach(position -> this.figures[position] = null);
        this.index = 0;
    }

    private int findBy(Cell cell) {
        return IntStream.range(0, this.figures.length).filter(
                ind -> this.figures[ind] != null && this.figures[ind].position().equals(cell)
        ).findFirst().orElse(-1);
    }
}