package ru.job4j.menu;

import java.util.*;

/**
 * Show menu.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 10.09.2019
 *@version 0.1
 */
public class ShowMenu extends BaseShow {

    public ShowMenu(IMenu menu) {
        super(menu);
    }

    /**
     * Space assignment based on menu level.
     * @param currentEntry Current entry.
     * @param peekEntry Next entry.
     * @param space Space filled with a delimiter.
     * @return
     */
    private String assignSpaceLength(IMenuEntry currentEntry, IMenuEntry peekEntry, String space) {
        String result = space;
        if (currentEntry.getName().equals(peekEntry.getParent().getName())) {
            result = String.format("%s%s", result, this.delimiter);
        } else {
            IMenuEntry currentFamily = currentEntry.getParent();
            while (!result.equals("")) {
                if (currentFamily != null && !currentFamily.getName().equals(peekEntry.getParent().getName())) {
                    currentFamily = currentFamily.getParent();
                    result = result.substring(this.delimiter.length());
                } else {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * To convert the menu entry into a string form.
     * @return
     */
    @Override
    public String menuToString() {
        StringJoiner result = new StringJoiner(System.lineSeparator());
        Deque<IMenuEntry> stack = new LinkedList<>();
        for (IMenuEntry entry : this.menu.getAll()) {
            stack.push(entry);
            String space = "";
            while (!stack.isEmpty()) {
                IMenuEntry value = stack.poll();
                result.add(String.format("%s%s", space, value.getName()));
                if (!value.getChildren().isEmpty()) {
                    List<IMenuEntry> list = new ArrayList<>(value.getChildren());
                    ListIterator<IMenuEntry> iter = list.listIterator(list.size());
                    while (iter.hasPrevious()) {
                        stack.push(iter.previous());
                    }
                }
                if (!stack.isEmpty()) {
                    space = assignSpaceLength(value, stack.peek(), space);
                }
            }
        }
        return result.toString();
    }
}
