package ru.job4j.menu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Menu entry.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 10.09.2019
 *@version 0.1
 */
public class MenuEntry implements IMenuEntry {

    private final String name;

    private IMenuEntry parent;

    private Set<IMenuEntry> children = new TreeSet<>();

    private IAction action;

    public MenuEntry(String name, IMenuEntry parent) {
        this.name = name;
        this.parent = parent;
        selfToParent(parent);
    }

    public MenuEntry(String name) {
        this.name = name;
    }

    /**
     * Binding this entry to its parent.
     * @param parent Parent menu entry to bind to.
     */
    private void selfToParent(IMenuEntry parent) {
        parent.getChildren().add(this);
    }

    /**
     * Get entry name.
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get parent entry.
     * @return
     */
    @Override
    public IMenuEntry getParent() {
        return parent;
    }

    /**
     * Get children entries.
     * @return
     */
    @Override
    public Set<IMenuEntry> getChildren() {
        return children;
    }

    /**
     * Search for an entry by name.
     * The search starts with the parent and runs through the entire descendant tree.
     * @param nameEntry
     * @return
     */
    @Override
    public IMenuEntry findByName(String nameEntry) {
        IMenuEntry result = null;
        Deque<IMenuEntry> stack = new LinkedList<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            result = stack.poll();
            if (result.getName().equals(nameEntry)) {
                break;
            } else {
                stack.addAll(result.getChildren());
                result = null;
            }
        }
        return result;
    }

    /**
     * Set the action for the menu entry.
     * @param action
     */
    @Override
    public void setAction(IAction action) {
        this.action = action;
    }

    /**
     * Execute action.
     * @return
     */
    @Override
    public boolean executeAction() {
        return this.action != null && this.action.executeAction();
    }

    /**
     * Lexicographic comparison by name.
     * @param o
     * @return
     */
    @Override
    public int compareTo(IMenuEntry o) {
        return this.name.compareTo(o.getName());
    }
}
