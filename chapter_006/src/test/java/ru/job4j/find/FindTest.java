package ru.job4j.find;

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
     * Search files by mask.
     * @throws IOException
     */
    @Test
    public void whenSearchFilesByMask() throws IOException {
        File root = this.createFileDir(false, new File(System.getProperty("java.io.tmpdir")), "RootDirectory");
        File oneDir = this.createFileDir(false, root, "OneDir");
        File twoDir = this.createFileDir(false, root, "TwoDir");
        File twoOneDir = this.createFileDir(false, twoDir, "TwoOneDir");
        File rootFile = this.createFileDir(true, root, "RootFile.txt");
        File oneDirFile = this.createFileDir(true, oneDir, "OneDirFile.txt");
        File twoDirFile = this.createFileDir(true, twoDir, "TwoDirFile.html");
        File twoOneDirFile = this.createFileDir(true, twoOneDir, "TwoOneFile.txt");
        File logFile = new File(root, "log.txt");
        String[] args =
                {
                        "-d", root.getAbsolutePath(), "-n", "*.txt", "-m", "-o", logFile.getAbsolutePath()
                };
        new Find(args).run();
        String[] result = this.resultArgs(logFile);
        String[] expected = {rootFile.getAbsolutePath(), oneDirFile.getAbsolutePath(), twoOneDirFile.getAbsolutePath()};
        assertTrue(logFile.exists());
        assertThat(result, arrayContainingInAnyOrder(expected));
        this.deleteTempFile(root);
    }

    /**
     * Search for files by full name.
     * @throws IOException
     */
    @Test
    public void whenSearchFilesByFullName() throws IOException {
        File root = this.createFileDir(false, new File(System.getProperty("java.io.tmpdir")), "RootDirectory");
        File oneDir = this.createFileDir(false, root, "OneDir");
        File twoDir = this.createFileDir(false, root, "TwoDir");
        File twoOneDir = this.createFileDir(false, twoDir, "TwoOneDir");
        File rootFile = this.createFileDir(true, root, "File.txt");
        File oneDirFile = this.createFileDir(true, oneDir, "File.txt");
        File twoDirFile = this.createFileDir(true, twoDir, "TwoDirFile.html");
        File twoOneDirFile = this.createFileDir(true, twoOneDir, "File.doc");
        File logFile = new File(root, "log.txt");
        String[] args =
                {
                        "-d", root.getAbsolutePath(), "-n", "File.txt", "-f", "-o", logFile.getAbsolutePath()
                };
        new Find(args).run();
        String[] result = this.resultArgs(logFile);
        String[] expected = {rootFile.getAbsolutePath(), oneDirFile.getAbsolutePath()};
        assertTrue(logFile.exists());
        assertThat(result, arrayContainingInAnyOrder(expected));
        this.deleteTempFile(root);
    }

    /**
     * Create a file/directory.
     * @param isFile True - create the file, false - create directory.
     * @param parent Parent directory.
     * @param name The name of the new directory/file.
     * @return Link to the created file/directory.
     * @throws IOException
     */
    public File createFileDir(boolean isFile, File parent, String name) throws IOException {
        File elem = new File(parent, name);
        if (isFile) {
            if (!elem.createNewFile()) {
                throw new IllegalStateException(String.format("File could not created %s", elem.getAbsoluteFile()));
            }
        } else {
            if (!elem.mkdir()) {
                throw new IllegalStateException(String.format("Directory could not created %s", elem.getAbsoluteFile()));
            }
        }
        return elem;
    }

    /**
     * Translates the contents of the log-file into an array.
     * @param logFile Target log-file.
     * @return Resulting array.
     * @throws IOException
     */
    public String[] resultArgs(File logFile) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        }
        return list.toArray(new String[0]);
    }

    /**
     * Recursive deletion of files and directories starting from the specified root directory.
     * @param root Root directory.
     */
    public void deleteTempFile(File root) {
        if (root.isDirectory()) {
            for (File value : root.listFiles()) {
                deleteTempFile(value);
            }
        }
        root.delete();
    }
}