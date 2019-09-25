package ru.job4j.battleship;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    @Test
    public void whenCreateBoardSize2ThenBoardContains4Cells() {
        IBoard board = new Board(2, new Cell());
        Set<ICell> result = board.getFreeCells();
        Set<ICell> expected = new TreeSet<>(Set.of(
                new Cell(1, 2), new Cell(2, 2),
                new Cell(1, 1), new Cell(2, 1)
        ));
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoardSize4AndAddShipSize3Start11HorizontalThenTrue() {
        IBoard board = new Board(4, new Cell());
        boolean result = board.addShip(new Ship(3), IShip.HORIZONTAL, 1, 1);
        assertThat(result, is(true));
    }

    @Test
    public void whenBoardSize3AndAddShipSize3Start11HorizontalThenThereWere3CellsWithCoordinate13And23And33() {
        IBoard board = new Board(3, new Cell());
        board.addShip(new Ship(3), IShip.HORIZONTAL, 1, 1);
        Set<ICell> result = board.getFreeCells();
        Set<ICell> expected = new TreeSet<>(Set.of(
                new Cell(1, 3), new Cell(2, 3), new Cell(3, 3)
        ));
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoardSize3AndAddShipSize1Start22HorizontalThenIsEmpty() {
        IBoard board = new Board(3, new Cell());
        board.addShip(new Ship(1), IShip.HORIZONTAL, 2, 2);
        Set<ICell> result = board.getFreeCells();
        Set<ICell> expected = new TreeSet<>();
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoardSize3AndAddTwoShipsHorizontalOneStart11Size1TwoStart13Size3ThenFreeCell31() {
        IBoard board = new Board(3, new Cell());
        board.addShip(new Ship(1), IShip.HORIZONTAL, 1, 1);
        board.addShip(new Ship(3), IShip.HORIZONTAL, 1, 3);
        Set<ICell> result = board.getFreeCells();
        Set<ICell> expected = new TreeSet<>(Set.of(new Cell(3, 1)));
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoardSize3AndAddTwoShipsVerticalOneStart11Size1TwoStart31Size3ThenFreeCell13() {
        IBoard board = new Board(3, new Cell());
        board.addShip(new Ship(1), IShip.VERTICAL, 1, 1);
        board.addShip(new Ship(3), IShip.VERTICAL, 3, 1);
        Set<ICell> result = board.getFreeCells();
        Set<ICell> expected = new TreeSet<>(Set.of(new Cell(1, 3)));
        assertThat(result, is(expected));
    }

    @Test(expected = RuntimeException.class)
    public void whenShipSizeMoreThanBoardSizeThenException() {
        IBoard board = new Board(3, new Cell());
        boolean result = board.addShip(new Ship(4), IShip.HORIZONTAL, 1, 1);
    }

    @Test
    public void whenBoardSize3ContainsOneHorizontalShipWithSize2ThenGetThisShip() {
        IBoard board = new Board(3, new Cell());
        IShip ship = new Ship(2);
        board.addShip(ship, IShip.HORIZONTAL, 1, 1);
        List<IShip> result = board.getShips();
        IShip expectedShip = new Ship(2);
        expectedShip.setLocation(new TreeSet<>(Set.of(new Cell(1, 1), new Cell(2, 1))));
        List<IShip> expected = new ArrayList<>(List.of(expectedShip));
        assertThat(result, is(expected));
    }

    @Test
    public void whenBoardSize3ContainsOneHorizontalShipWithSize3ThenAreaAroundShip3Cells() {
        IBoard board = new Board(3, new Cell());
        IShip ship = new Ship(3);
        board.addShip(ship, IShip.HORIZONTAL, 1, 1);
        Set<ICell> result = board.getAreaShips();
        Set<ICell> expected = new TreeSet<>(Set.of(
                new Cell(1, 2), new Cell(2, 2), new Cell(3, 2)
        ));
        assertThat(result, is(expected));
    }
}