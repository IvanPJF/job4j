package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**Тест Удаление дубликатов в массиве.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 15.09.2018
 *@version 0.1
 */
public class ArrayDuplicateTest {

    /**
     * Тест Удаляем дубликаты в массиве.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"День", "Ночь", "День", "Ночь", "Вторник", "Ночь"};
        String[] expect = {"День", "Ночь", "Вторник"};
        ArrayDuplicate array = new ArrayDuplicate();
        String[] result = array.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
