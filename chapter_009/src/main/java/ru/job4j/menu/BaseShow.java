package ru.job4j.menu;

/**
 * Abstract show menu.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 10.09.2019
 *@version 0.1
 */
public abstract class BaseShow implements IShowMenu {

    protected final IMenu menu;

    protected String delimiter = "--";

    public BaseShow(IMenu menu) {
        this.menu = menu;
    }

    /**
     * Show menu.
     * @return Menu in string form.
     */
    @Override
    public String show() {
        String result = menuToString();
        System.out.println(result);
        return result;
    }

    /**
     * Set divider to show menu sub-entry.
     * @param delimiter
     */
    @Override
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Offer to select a menu item.
     * @param ask
     * @return
     */
    @Override
    public String ask(String ask) {
        System.out.println(ask);
        return ask;
    }
}
