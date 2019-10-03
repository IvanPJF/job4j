package ru.job4j.tictactoe;

import java.util.Scanner;

/**
 * Computer interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 03.10.2019
 */
public interface IPlayer {

    /**
     * Makes a move.
     * @return
     */
    void move(IBoard board, IShow show, Scanner scanner);

    String getMark();
}
