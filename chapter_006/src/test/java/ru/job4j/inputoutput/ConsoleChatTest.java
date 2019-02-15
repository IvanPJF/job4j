package ru.job4j.inputoutput;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 * Console chat.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 15.02.2019
 *@version 0.1
 */
public class ConsoleChatTest {

    private String tmpDir = System.getProperty("java.io.tmpdir");
    private File tmp = new File(tmpDir, "tmp");
    private List<String> answerList = Arrays.asList(
            "Hello!",
            "How are you?",
            "Speak a little quieter, or they'll hear"
    );

    /**
     * Create a temporary directory and file.
     */
    @Before
    public void createDirAndFiles() {
        this.tmp.mkdir();
        File answerFile = new File(tmp, "Answer.txt");
        this.createFile(answerFile, this.answerList);
    }

    /**
     * Create and populate a file.
     * @param file File name.
     * @param text Text to fill in the file.
     */
    private void createFile(File file, List<String> text) {
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file))) {
            for (String value : text) {
                buffWrite.write(value);
                buffWrite.newLine();
            }
            buffWrite.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * The conversation with the bot.
     * @throws IOException IOException.
     */
    @Test
    public void whenCommunicateWithBot() throws IOException {
        File answerFile = new File(this.tmp, "Answer.txt");
        File logFile = new File(this.tmp, "Log.txt");
        File questionFile = new File(this.tmp, "MyQuestion.txt");
        List<String> questionList = Arrays.asList(
                "hi",
                "stop",
                "continue",
                "hi again",
                "exit"
        );
        this.createFile(questionFile, questionList);
        Scanner scanner = new Scanner(new FileInputStream(questionFile));
        String[] pathsToFiles = new String[]{answerFile.getPath(), logFile.getPath()};
        ConsoleChat consoleChat = new ConsoleChat(pathsToFiles);
        consoleChat.chat(scanner, this.answerList, logFile);
        BufferedReader buffReadResult = new BufferedReader(new FileReader(logFile));
        assertEquals(buffReadResult.readLine(), "hi");
        assertThat(this.answerList.contains(buffReadResult.readLine()), is(true));
        assertEquals(buffReadResult.readLine(), "stop");
        assertEquals(buffReadResult.readLine(), "continue");
        assertEquals(buffReadResult.readLine(), "hi again");
        assertThat(this.answerList.contains(buffReadResult.readLine()), is(true));
        assertEquals(buffReadResult.readLine(), "exit");
        assertNull(buffReadResult.readLine());
        buffReadResult.close();
        scanner.close();
    }

    /**
     * Delete the temporary directory.
     */
    @After
    public void deleteAllFilesAndDirForThisApp() {
        deleteFile(this.tmp);
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