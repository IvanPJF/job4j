package ru.job4j.tictactoe;

import java.util.Scanner;

public class HumanPlayer extends BasePlayer {

    public HumanPlayer(String mark, String name) {
        super(mark, String.format("[Human] %s", name));
    }

    @Override
    public void move(IBoard board, IShow show, Scanner scanner) {
        show.drawBoard();
        int x = show.askNumber(show.getTextRow(), scanner);
        int y = show.askNumber(show.getTextColumn(), scanner);
        board.choiceCell(x, y, this.getMark());
    }
}
