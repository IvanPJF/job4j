package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**Конвертация List в HashMap.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 17.10.2018
 *@version 0.1
 */
public class UserConvert {

    /**
     * Метод конвретирует List в HashMap.
     * @param list список для конвертации в массив.
     * @return HashMap конвертированный из List.
     */
    public HashMap<Integer, User> process(List<User> list) {
        return list.stream().collect(Collectors.toMap(
                User::getId, Function.identity(), (x, y) -> y, HashMap::new)
        );
    }
}
