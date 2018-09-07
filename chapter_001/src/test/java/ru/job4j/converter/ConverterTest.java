package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест конвертера валют.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 07.09.2018
 *@version 0.1
 */
public class ConverterTest {

    /**
     * Тест рубли в доллары.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    /**
     * Тест рубли в евро.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }

    /**
     * Тест доллары в рубли.
     */
    @Test
    public void when1DollarToRubleThen60() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(60));
    }

    /**
     * Тест евро в рубли.
     */
    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(70));
    }
}
