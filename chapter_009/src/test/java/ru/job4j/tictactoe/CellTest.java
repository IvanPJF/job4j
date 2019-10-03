package ru.job4j.tictactoe;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CellTest {

    @Test
    public void whenCreateCell12ThenXIs1YIs2() {
        ICell cell = new Cell(1, 2);
        int x = cell.getX();
        int y = cell.getY();
        assertThat(x, is(1));
        assertThat(y, is(2));
    }

    @Test
    public void whenFactoryCell12ThenReturnCell12() {
        ICell result = new Cell().factoryCell(1, 2);
        ICell expected = new Cell(1, 2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCellIsChoiceTrueThenReturnIsChoiceTrue() {
        ICell cell = new Cell();
        cell.setChoice(true);
        boolean result = cell.isChoice();
        assertThat(result, is(true));
    }

    @Test
    public void whenCellSetMarkIsXThenGetMarkIsX() {
        ICell cell = new Cell();
        String input = "X";
        cell.setMark(input);
        String result = cell.getMark();
        assertThat(result, is(input));
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
}