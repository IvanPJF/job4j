package ru.job4j.menu;

import java.io.InputStream;
import java.util.Scanner;

/**
 * The start menu in interactive mode.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 10.09.2019
 *@version 0.1
 */
public class StartUI {

    private final IMenu menu;

    private final IShowMenu show;

    private static final String EXIT = "q";

    public StartUI(IMenu menu, IShowMenu show) {
        this.menu = menu;
        this.show = show;
    }

    /**
     * Start menu.
     * @param is Input source.
     */
    public void run(InputStream is) {
        try (Scanner sc = new Scanner(is)) {
            String input = null;
            do {
                IMenuEntry menuEntry = null;
                show.show();
                show.ask(String.format("Select menu item (for exit \"%s\"): ", EXIT));
                input = sc.nextLine();
                menuEntry = menu.findByName(input);
                if (menuEntry != null) {
                    menuEntry.executeAction();
                }
            } while (!input.equals(EXIT));
        }
    }
}
