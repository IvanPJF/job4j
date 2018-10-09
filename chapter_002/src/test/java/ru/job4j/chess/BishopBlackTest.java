package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    /**
     * Проверка возможности хода.
     * @param moving Фигура, которая перемещается по доске.
     * @param stand Фигура, которая может служить препятствием(стоит на месте) движущейся фигуре.
     * @param source Начальная точка.
     * @param dest Целевая точка.
     */
    public boolean start(Figure moving, Figure stand, Cell source, Cell dest) {
        Logic logic = new Logic();
        logic.add(moving);
        logic.add(stand);
        return logic.move(source, dest);
    }

    @Test
    public void whenPawnBlackPreventBishopBlackThenFalse() {
        boolean result = start(
                new BishopBlack(Cell.F8),
                new PawnBlack(Cell.E7),
                Cell.F8, Cell.C5
        );
        assertThat(result, is(false));
    }

    @Test
    public void whenPawnBlackNotPreventBishopBlackThenTrue() {
        boolean result = start(
                new BishopBlack(Cell.F8),
                new PawnBlack(Cell.E6),
                Cell.F8, Cell.C5
        );
        assertThat(result, is(true));
    }

    @Test
    public void whenBishopBlackMovingNotThereThenFalse() {
        boolean result = start(
                new BishopBlack(Cell.F8),
                new PawnBlack(Cell.E7),
                Cell.F8, Cell.F7
        );
        assertThat(result, is(false));
    }
}
