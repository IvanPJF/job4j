package ru.job4j.menu;

import java.util.Set;

/**
 * Menu interface.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 10.09.2019
 *@version 0.1
 */
public interface IMenu {

    /**
     * Add menu entry/entries.
     * @param entries
     */
    void addEntries(IMenuEntry... entries);

    /**
     * Get all menu entries.
     * @return Menu entries.
     */
    Set<IMenuEntry> getAll();

    /**
     * Search for a menu entry by name.
     * @param nameEntry
     * @return
     */
    IMenuEntry findByName(String nameEntry);
}
