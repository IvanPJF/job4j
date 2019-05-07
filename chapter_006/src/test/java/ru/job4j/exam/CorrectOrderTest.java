package ru.job4j.exam;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * Define the order in which scripts are run.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 07.05.2019
 *@version 0.1
 */
public class CorrectOrderTest {

    @Test
    public void whenScriptsNotSorted() {
        List<VulnerabilityScript> notSortedList = Arrays.asList(
                new VulnerabilityScript(3, Arrays.asList(1, 2, 4)),
                new VulnerabilityScript(5, Arrays.asList(1, 2, 3, 4)),
                new VulnerabilityScript(1, Arrays.asList(4)),
                new VulnerabilityScript(2, Arrays.asList(4)),
                new VulnerabilityScript(4, null)
        );
        CorrectOrder order = new CorrectOrder(notSortedList);
        List<Integer> result = order.sort();
        List<Integer> expected = Arrays.asList(4, 1, 2, 3, 5);
        assertThat(result, is(expected));
    }

    @Test
    public void whenScriptsNotDependencies() {
        List<VulnerabilityScript> notSortedList = Arrays.asList(
                new VulnerabilityScript(1, null),
                new VulnerabilityScript(5, null),
                new VulnerabilityScript(2, null),
                new VulnerabilityScript(3, null),
                new VulnerabilityScript(4, null)
        );
        CorrectOrder order = new CorrectOrder(notSortedList);
        List<Integer> result = order.sort();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(result, is(expected));
    }
}