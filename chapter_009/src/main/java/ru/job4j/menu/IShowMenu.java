package ru.job4j.menu;

/**
 * Show menu interface.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 10.09.2019
 *@version 0.1
 */
public interface IShowMenu {

    /**
     * Show menu.
     * @return Menu in string form.
     */
    String show();

    /**
     * To convert the menu entry into a string form.
     * @return
     */
    String menuToString();

    /**
     * Set divider to show menu sub-entry.
     * @param delimiter
     */
    void setDelimiter(String delimiter);

    /**
     * Offer to select a menu item.
     * @param ask
     * @return
     */
    String ask(String ask);
}