package ru.job4j.inputoutput;

import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест.
 * Сканирование файловой системы.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 31.01.2019
 *@version 0.1
 */
public class SearchTest {

    /**
     * Создание временной корневой директории с вложенными в неё директориями и файлами.
     * Фильтрация созданных файлов по расширению.
     * @throws IOException
     */
    @Test
    public void whenFilterFiles() throws IOException {
        String tmpDir = System.getProperty("java.io.tmpdir");
        File root = new File(tmpDir, "RootDirectory");
        File oneDir = new File(root.getPath(), "OneDir");
        File twoDir = new File(root.getPath(), "TwoDir");
        File twoOneDir = new File(twoDir.getPath(), "TwoOneDir");
        File rootFile = new File(root, "RootFile.txt");
        File oneDirFile = new File(oneDir, "OneDirFile.exe");
        File twoDirFile = new File(twoDir, "TwoDirFile.html");
        File twoOneDirFile = new File(twoOneDir, "TwoOneFile.xml");
        root.mkdir();
        oneDir.mkdir();
        twoDir.mkdir();
        twoOneDir.mkdir();
        rootFile.createNewFile();
        oneDirFile.createNewFile();
        twoDirFile.createNewFile();
        twoOneDirFile.createNewFile();
        List<String> listFilter = new ArrayList<>(Arrays.asList(".exe", ".txt"));
        String path = root.getPath();
        List<File> result = new Search().files(path, listFilter);
        List<File> expected = new LinkedList<>(Arrays.asList(rootFile, oneDirFile));
        assertThat(result, is(expected));
    }

    /**
     * Удаление временной дирректории.
     */
    @After
    public void delete() {
        String tmpDir = System.getProperty("java.io.tmpdir");
        File root = new File(tmpDir, "RootDirectory");
        deleteFile(root);
    }

    /**
     * Рекурсивное удаление файлов и директорий начиная с указанной корневой директории.
     * @param file Корневая директория.
     */
    public void deleteFile(File file) {
        if (file.isDirectory()) {
            for (File value : file.listFiles()) {
                deleteFile(value);
            }
        }
        file.delete();
    }
}