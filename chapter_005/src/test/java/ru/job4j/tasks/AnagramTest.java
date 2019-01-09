package ru.job4j.tasks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Анаграмма.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 09.01.2019
 *@version 0.1
 */
public class AnagramTest {

    /**
     * Слова являются анаграммами.
     */
    @Test
    public void whenWordsIsAnagramThenTrue() {
        String wordOne = "КАБАН";
        String wordTwo = "БАНКА";
        boolean result = new Anagram().checkAnagram(wordOne, wordTwo);
        assertThat(result, is(true));
    }

    /**
     * Слова являются анаграммами.
     * Регистр не имеет значения.
     */
    @Test
    public void whenWordsHasDifferentRegistersAndIsAnagramThenTrue() {
        String wordOne = "КАБАН";
        String wordTwo = "банка";
        boolean result = new Anagram().checkAnagram(wordOne, wordTwo);
        assertThat(result, is(true));
    }

    /**
     * Слова не являются анаграммами.
     */
    @Test
    public void whenWordsIsNotAnagramThenFalse() {
        String wordOne = "КАБАНКА";
        String wordTwo = "БАНАНАН";
        boolean result = new Anagram().checkAnagram(wordOne, wordTwo);
        assertThat(result, is(false));
    }

    /**
     * Слова не являются анаграммами.
     * Разное количество символов в словах.
     */
    @Test
    public void whenWordsLengthIsDisparateThenFalse() {
        String wordOne = "КАБАН";
        String wordTwo = "БАНК";
        boolean result = new Anagram().checkAnagram(wordOne, wordTwo);
        assertThat(result, is(false));
    }
}