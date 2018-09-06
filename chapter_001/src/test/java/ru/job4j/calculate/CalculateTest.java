package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 06.09.2018
 *@version 0.1
 */
public class CalculateTest {
	/**
	 * Test echo.
	 */
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Ivan Krinitsyn";
		String expect = "Echo, echo, echo : Ivan Krinitsyn";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}

}