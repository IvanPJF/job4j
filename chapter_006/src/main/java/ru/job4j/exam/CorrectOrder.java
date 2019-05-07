package ru.job4j.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Define the order in which scripts are run.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 07.05.2019
 *@version 0.1
 */
public class CorrectOrder {

    /**
     * Vertices and their list of dependencies.
     **/
    private HashMap<Integer, List<Integer>> vertDepend;

    /**
     * The color of the vertices.
     * 0 - white(vertex not checked), 1 - black(vertex checked).
     **/
    private HashMap<Integer, Integer> vertColor;

    /**
     * A list of script IDs with the correct startup order.
     */
    private final List<Integer> sortScript;

    public CorrectOrder(List<VulnerabilityScript> scriptsList) {
        this.scriptsToHash(scriptsList);
        this.sortScript = new ArrayList<>(scriptsList.size());
    }

    /**
     * Vertices and their dependencies are entered in HashMap.
     * Each vertex is colored white(0).
     *
     * @param scriptList List of unsorted scripts.
     */
    private void scriptsToHash(List<VulnerabilityScript> scriptList) {
        int sizeHash = (int) (scriptList.size() / 0.75);
        this.vertDepend = new HashMap<>(sizeHash);
        this.vertColor = new HashMap<>(sizeHash);
        for (VulnerabilityScript value : scriptList) {
            this.vertDepend.put(value.getScriptId(), value.getDependencies());
            this.vertColor.put(value.getScriptId(), 0);
        }
    }

    /**
     * Sort the order in which scripts are run by script id and its dependencies.
     *
     * @return The order of running scripts by id.
     */
    public List<Integer> sort() {
        Set<Integer> vertKey = this.vertDepend.keySet();
        for (int vertex : vertKey) {
            this.dfs(vertex);
        }
        return this.sortScript;
    }

    /**
     * Determining the order in which scripts are run.
     *
     * @param vertex Vertex to check.
     */
    private void dfs(int vertex) {
        if (this.vertColor.get(vertex) == 0) {
            if (this.vertDepend.get(vertex) != null) {
                for (int depend : this.vertDepend.get(vertex)) {
                    dfs(depend);
                }
            }
            this.sortScript.add(vertex);
            this.vertColor.replace(vertex, 1);
        }
    }
}
