package ru.job4j.battleship;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CellTest {

    @Test
    public void whenCreateCellWithCoordinates1And1ThenResultXIs1AndResultYIs1() {
        ICell cell = new Cell(1, 1);
        int resultX = cell.getX();
        int resultY = cell.getY();
        assertThat(resultX, is(1));
        assertThat(resultY, is(1));
    }

    @Test
    public void whenCellIsChoiceThenUseIsChoiceTrue() {
        ICell cell = new Cell(1, 1);
        cell.setChoice(true);
        boolean result = cell.isChoice();
        assertThat(result, is(true));
    }

    @Test
    public void whenCellIsNotChoiceThenUseIsChoiceFalse() {
        ICell cell = new Cell(1, 1);
        boolean result = cell.isChoice();
        assertThat(result, is(false));
    }

    @Test
    public void whenCompareThreeCellsThenGetLineOfCellsVertically() {
        ICell cellFirst = new Cell(2, 2);
        ICell cellSecond = new Cell(2, 3);
        ICell cellThird = new Cell(2, 4);
        Iterator<ICell> result = new TreeSet<>(Set.of(cellThird, cellSecond, cellFirst)).iterator();
        assertThat(result.next(), is(cellFirst));
        assertThat(result.next(), is(cellSecond));
        assertThat(result.next(), is(cellThird));
    }

    @Test
    public void whenCompareThreeCellsThenGetLineOfCellsHorizontally() {
        ICell cellFirst = new Cell(2, 2);
        ICell cellSecond = new Cell(3, 2);
        ICell cellThird = new Cell(4, 2);
        Iterator<ICell> result = new TreeSet<>(Set.of(cellThird, cellSecond, cellFirst)).iterator();
        assertThat(result.hasNext(), is(true));
        assertThat(result.next(), is(cellFirst));
        assertThat(result.next(), is(cellSecond));
        assertThat(result.next(), is(cellThird));
        assertThat(result.hasNext(), is(false));
    }

    @Test
    public void whenTwoIdenticalCellsThenOneCell() {
        ICell cellFirst = new Cell(2, 2);
        ICell cellSecond = new Cell(2, 2);
        Iterator<ICell> result = new TreeSet<>(List.of(cellSecond, cellFirst)).iterator();
        assertThat(result.hasNext(), is(true));
        assertThat(result.next(), is(cellSecond));
        assertThat(result.hasNext(), is(false));
    }
}