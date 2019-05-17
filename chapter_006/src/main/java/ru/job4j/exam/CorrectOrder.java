package ru.job4j.exam;

import java.util.*;

/**
 * Define the order in which scripts are run.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 07.05.2019
 */
public class CorrectOrder {

    /**
     * Vertices and their list of dependencies.
     **/
    private HashMap<Integer, List<Integer>> vertDepend;

    /**
     * The color of the vertices.
     **/
    private HashMap<Integer, Integer> vertColor;

    /**
     * A list of script IDs with the correct startup order.
     */
    private final List<Integer> sortScript;

    /**
     * Vertex not checked.
     */
    private static final int WHITE = 0;

    /**
     * The vertex is added to the stack.
     */
    private static final int GRAY = 1;

    /**
     * Vertex checked.
     */
    private static final int BLACK = 2;

    public CorrectOrder(List<VulnerabilityScript> scriptsList) {
        this.scriptsToHash(scriptsList);
        this.sortScript = new ArrayList<>(scriptsList.size());
    }

    /**
     * Vertices and their dependencies are entered in HashMap.
     * Each vertex is colored white.
     *
     * @param scriptList List of unsorted scripts.
     */
    private void scriptsToHash(List<VulnerabilityScript> scriptList) {
        int sizeHash = (int) (scriptList.size() / 0.75);
        this.vertDepend = new HashMap<>(sizeHash);
        this.vertColor = new HashMap<>(sizeHash);
        for (VulnerabilityScript value : scriptList) {
            this.vertDepend.put(value.getScriptId(), value.getDependencies());
            this.vertColor.put(value.getScriptId(), WHITE);
        }
    }

    /**
     * Sort the order in which scripts are run by script id and its dependencies.
     *
     * @return The order of running scripts by id.
     */
    public List<Integer> sort() {
        Set<Integer> vertKey = this.vertDepend.keySet();
        Deque<Integer> stack = new LinkedList<>();
        for (Integer vertex : vertKey) {
            if (this.vertColor.get(vertex) == WHITE) {
                if (this.hasDependencies(vertex)) {
                    stack.push(vertex);
                    this.vertColor.replace(vertex, GRAY);
                    for (Integer depend : this.vertDepend.get(vertex)) {
                        if (this.vertColor.get(depend) == WHITE) {
                            stack.push(depend);
                            this.vertColor.replace(depend, GRAY);
                        }
                    }
                } else {
                    this.sortScript.add(vertex);
                    this.vertColor.replace(vertex, BLACK);
                }
            }
            this.parseStack(stack);
        }
        return this.sortScript;
    }

    /**
     * Check the stack items to see if they can be added to the result list.
     *
     * @param stack
     */
    private void parseStack(Deque<Integer> stack) {
        while (!stack.isEmpty()) {
            Integer stackElem = stack.peek();
            if (this.vertColor.get(stackElem) == GRAY) {
                if (this.hasDependencies(stackElem)) {
                    for (Integer value : this.vertDepend.get(stackElem)) {
                        if (this.vertColor.get(value) != BLACK) {
                            break;
                        }
                    }
                }
                this.sortScript.add(stack.pop());
                this.vertColor.replace(stackElem, BLACK);
            } else {
                stack.pop();
            }
        }
    }

    /**
     * Check whether the vertex has dependencies.
     *
     * @param vertex
     * @return
     */
    private boolean hasDependencies(Integer vertex) {
        return this.vertDepend.get(vertex) != null && !this.vertDepend.get(vertex).isEmpty();
    }
}
