package ru.job4j.tasks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Парсинг скобок.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.01.2019
 *@version 0.1
 */
public class BracketsTest {

    /**
     * Скобки расставлены верно.
     */
    @Test
    public void whenBracketsIsValidThenTrue() {
        Brackets brackets = new Brackets();
        boolean result = brackets.bracketsValid("{[(){}]}");
        assertThat(result, is(true));
    }

    /**
     * Скобки расставлены не верно.
     */
    @Test
    public void whenBracketsIsInvalidThenFalse() {
        Brackets brackets = new Brackets();
        boolean result = brackets.bracketsValid("{[}]");
        assertThat(result, is(false));
    }

    /**
     * Скобки расставлены не верно.
     * Осталась одна не закрытая скобка.
     */
    @Test
    public void whenBracketsIsInvalidAndResidueBracketInLeftThenFalse() {
        Brackets brackets = new Brackets();
        boolean result = brackets.bracketsValid("([{}]");
        assertThat(result, is(false));
    }

    /**
     * Скобки расставлены не верно.
     * Закрывающая скобка поставлена без открывающей скобки.
     */
    @Test
    public void whenBracketsIsInvalidAndResidueBracketInRightThenFalse() {
        Brackets brackets = new Brackets();
        boolean result = brackets.bracketsValid("[{}])");
        assertThat(result, is(false));
    }
}