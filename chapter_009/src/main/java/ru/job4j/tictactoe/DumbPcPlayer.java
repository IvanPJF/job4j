package ru.job4j.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Dumb computer player.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 03.10.2019
 */
public class DumbPcPlayer extends BasePlayer {

    private List<ICell> freeCells = new ArrayList<>();

    public DumbPcPlayer(String mark, String name) {
        super(mark, String.format("[Computer] %s", name));
    }

    /**
     * Makes a move.
     * Makes a random selection of the remaining cells.
     *
     * @return
     */
    @Override
    public void move(IBoard board, IShow show, Scanner scanner) {
        checkFreeCells(board);
        ICell pickCell = randomCell();
        if (pickCell != null) {
            board.choiceCell(pickCell.getX(), pickCell.getY(), this.getMark());
        }
        show.drawBoard();
    }

    private void checkFreeCells(IBoard board) {
        this.freeCells.clear();
        board.allCells().stream()
                .filter(cell -> !cell.isChoice())
                .forEach(cell -> this.freeCells.add(cell));
    }

    /**
     * Makes a random selection of the remaining cells.
     *
     * @return
     */
    private ICell randomCell() {
        int rndNumberCell = new Random().nextInt(this.freeCells.size());
        return this.freeCells.remove(rndNumberCell);
    }
}
