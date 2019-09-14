package ru.job4j.generator;

/**
 * Generator interface.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2019
 *@version 0.1
 */
public interface IGenerator {

    /**
     * Generation a string from a template and values.
     * @param template Pattern for string generation.
     * @param data The values for substitution in the template.
     * @return Resulting string.
     */
    String generate(String template, String... data);
}
