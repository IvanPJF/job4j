package ru.job4j.find;

import org.junit.After;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test.
 * File search.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 31.03.2019
 *@version 0.1
 */
public class FindTest {

    /**
     * Create a temporary root directory with directories and files attached to it.
     * Created by filtering files by extension.
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
        File oneDirFile = new File(oneDir, "OneDirFile.txt");
        File twoDirFile = new File(twoDir, "TwoDirFile.html");
        File twoOneDirFile = new File(twoOneDir, "TwoOneFile.txt");
        root.mkdir();
        oneDir.mkdir();
        twoDir.mkdir();
        twoOneDir.mkdir();
        rootFile.createNewFile();
        oneDirFile.createNewFile();
        twoDirFile.createNewFile();
        twoOneDirFile.createNewFile();
        String pathDir = root.getAbsolutePath();
        String logFile = pathDir + System.getProperty("file.separator") + "log.txt";
        String[] args =
                {
                        "-d", pathDir, "-n", "*.txt", "-m", "-o", logFile
                };
        new Find(args).run();
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(logFile));
        String line = null;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        String[] result = list.toArray(new String[0]);
        String[] expected = {rootFile.getAbsolutePath(), oneDirFile.getAbsolutePath(), twoOneDirFile.getAbsolutePath()};
        assertTrue(new File(logFile).exists());
        assertThat(result, arrayContainingInAnyOrder(expected));
    }

    /**
     * Delete the temporary directory.
     */
    @After
    public void delete() {
        String tmpDir = System.getProperty("java.io.tmpdir");
        File root = new File(tmpDir, "RootDirectory");
        deleteFile(root);
    }

    /**
     * Recursive deletion of files and directories starting from the specified root directory.
     * @param file Root directory.
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