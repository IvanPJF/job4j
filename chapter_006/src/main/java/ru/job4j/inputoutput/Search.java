package ru.job4j.inputoutput;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Сканирование файловой системы.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 31.01.2019
 *@version 0.1
 */
public class Search {

    /**
     * Ищет файлы по расширению во всей структуре директорий, начиная с корневой директории.
     * @param parent Корневая директория.
     * @param exts Список расширений.
     * @return Список найденных файлов.
     */
    public List<File> files(String parent, List<String> exts) {
        Queue<String> queueDir = new LinkedList<>();
        queueDir.offer(parent);
        List<File> result = null;
        while (!queueDir.isEmpty()) {
            File file = new File(queueDir.poll());
            for (File value : file.listFiles()) {
                if (value.isDirectory()) {
                    queueDir.offer(value.getPath());
                } else if (result != null) {
                    result.addAll(this.searchFiles(value, exts));
                } else {
                    result = this.searchFiles(value, exts);
                }
            }
        }
        return result;
    }

    /**
     * Сравнивает расширение проверяемого файла со списком необходимых расширений.
     * @param file Проверяемый файл.
     * @param exts Список расширений.
     * @return Список подходящих файлов.
     */
    private List<File> searchFiles(File file, List<String> exts) {
        List<File> result = new LinkedList<>();
        for (String value : exts) {
            if (value.charAt(0) == '.' && file.getName().endsWith(value)
                    || file.getName().endsWith("." + value)) {
                result.add(file);
            }
        }
        return result;
    }
}
