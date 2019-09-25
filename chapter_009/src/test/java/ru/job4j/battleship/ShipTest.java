package ru.job4j.battleship;

import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShipTest {

    @Test
    public void whenCreateShipWithSizeOneThenSizeOne() {
        IShip ship = new Ship(1);
        int size = ship.size();
        assertThat(size, is(1));
    }

    @Test
    public void whenShipWithoutLocationThenGetLocationCellsIsEmpty() {
        IShip ship = new Ship(1);
        Set<ICell> result = ship.getLocationCells();
        assertThat(result, is(Collections.EMPTY_SET));
    }

    @Test
    public void whenShipWithLocationX1Y1ThenGetLocationCellsIsSetWithCellX1Y1() {
        IShip ship = new Ship(1);
        ICell cellInput = new Cell(1, 1);
        ship.setLocation(Set.of(cellInput));
        Set<ICell> result = ship.getLocationCells();
        assertThat(result, is(Set.of(cellInput)));
    }

    @Test
    public void whenShipFormLineThenIsCorrectTrue() {
        IShip ship = new Ship(3);
        ICell firstCell = new Cell(1, 1);
        ICell secondCell = new Cell(1, 2);
        ICell thirdCell = new Cell(1, 3);
        boolean result = ship.isCorrect(Set.of(firstCell, secondCell, thirdCell));
        assertThat(result, is(true));
    }

    @Test
    public void whenShipFormNotLineThenIsCorrectFalse() {
        IShip ship = new Ship(3);
        ICell startCell = new Cell(1, 1);
        ICell secondCell = new Cell(1, 2);
        ICell thirdCell = new Cell(2, 1);
        boolean result = ship.isCorrect(Set.of(startCell, secondCell, thirdCell));
        assertThat(result, is(false));
    }

    @Test(expected = RuntimeException.class)
    public void whenSizeShipNotEqualToNumberOfCellsThenException() {
        IShip ship = new Ship(4);
        ICell startCell = new Cell(1, 1);
        ICell secondCell = new Cell(1, 2);
        ICell thirdCell = new Cell(1, 3);
        ship.isCorrect(Set.of(startCell, secondCell, thirdCell));
    }

    @Test
    public void whenShipIsKilledThenTrue() {
        IShip ship = new Ship(2);
        ship.setLocation(new TreeSet<>(Set.of(new Cell(2, 2), new Cell(3, 2))));
        Iterator<ICell> iterLocate = ship.getLocationCells().iterator();
        ICell cellOne = iterLocate.next();
        cellOne.setChoice(true);
        ICell cellTwo = iterLocate.next();
        cellTwo.setChoice(true);
        boolean result = ship.isKilled();
        assertThat(result, is(true));
    }

    @Test
    public void whenShipIsNotKilledThenFalse() {
        IShip ship = new Ship(2);
        ship.setLocation(new TreeSet<>(Set.of(new Cell(2, 2), new Cell(3, 2))));
        boolean result = ship.isKilled();
        assertThat(result, is(false));
    }
}