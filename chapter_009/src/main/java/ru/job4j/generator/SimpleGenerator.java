package ru.job4j.generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Simple string generator.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 14.09.2019
 *@version 0.1
 */
public class SimpleGenerator implements IGenerator {

    private final Pattern keys = Pattern.compile("\\$\\{.+?}");
    private Map<String, String> mapValues = new HashMap<>();

    /**
     * Generation a string from a template and values.
     * @param template Pattern for string generation.
     * @param data     The values for substitution in the template.
     * @return Resulting string.
     */
    @Override
    public String generate(String template, String... data) {
        String result = null;
        Matcher matcher = keys.matcher(template);
        Iterator<String> iterData = Stream.of(data).iterator();
        while (matcher.find()) {
            String group = matcher.group();
            if (!mapValues.containsKey(group)) {
                exceptionIfTrue(!iterData.hasNext(), "Many keys");
                mapValues.put(group, iterData.next());
                matcher.reset();
            } else {
                result = matcher.replaceFirst(mapValues.get(group));
                matcher.reset(result);
            }
        }
        exceptionIfTrue(iterData.hasNext(), "Not enough keys");
        return result;
    }

    /**
     * Conditional test.
     * If the condition is not met, an exception is thrown.
     * @param checkValue    Condition that is checked.
     * @param textException Text for the thrown exception.
     */
    private void exceptionIfTrue(boolean checkValue, String textException) {
        if (checkValue) {
            throw new RuntimeException(textException);
        }
    }
}
