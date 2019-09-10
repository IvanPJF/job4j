package ru.job4j.menu;

import java.util.Set;

/**
 * Menu entry interface.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 10.09.2019
 *@version 0.1
 */
public interface IMenuEntry extends Comparable<IMenuEntry>, IAction {

    /**
     * Get entry name.
     * @return
     */
    String getName();

    /**
     * Get parent entry.
     * @return
     */
    IMenuEntry getParent();

    /**
     * Get children entries.
     * @return
     */
    Set<IMenuEntry> getChildren();

    /**
     * Search for an entry by name.
     * @param nameEntry
     * @return
     */
    IMenuEntry findByName(String nameEntry);

    /**
     * Set the action for the menu entry.
     * @param action
     */
    void setAction(IAction action);
}
