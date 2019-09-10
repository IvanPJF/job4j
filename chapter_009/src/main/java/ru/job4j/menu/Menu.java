package ru.job4j.menu;

import java.util.Set;
import java.util.TreeSet;

/**
 * Menu.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 10.09.2019
 *@version 0.1
 */
public class Menu implements IMenu {

    /**
     * Storage of parent menu entries.
     */
    private Set<IMenuEntry> parentEntries = new TreeSet<>();

    /**
     * Add menu entry/entries.
     * Only parent menu entries are added.
     * @param entries
     */
    @Override
    public void addEntries(IMenuEntry... entries) {
        for (IMenuEntry value : entries) {
            if (value.getParent() == null) {
                this.parentEntries.add(value);
            }
        }
    }

    /**
     * Get all menu entries.
     * @return Menu entries.
     */
    @Override
    public Set<IMenuEntry> getAll() {
        return parentEntries;
    }

    /**
     * Search for a menu entry by name.
     * @param nameEntry
     * @return
     */
    @Override
    public IMenuEntry findByName(String nameEntry) {
        IMenuEntry result = null;
        for (IMenuEntry parent : parentEntries) {
            result = parent.findByName(nameEntry);
            if (result != null) {
                break;
            }
        }
        return result;
    }
}
