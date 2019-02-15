package ru.job4j.inputoutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Console chat.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 12.02.2019
 *@version 0.1
 */
public class ConsoleChat {

    private static final String STOP = "stop";
    private static final String CONTINUE = "continue";
    private static final String EXIT = "exit";
    private static final List<String> LIST_COMMANDS = Arrays.asList(STOP, CONTINUE, EXIT);
    private List<String> listAnswer;
    private String pathLog;

    public ConsoleChat(String[] args) {
        this.listAnswer = this.fileToArray(args[0]);
        this.pathLog = args[1];
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat(args);
        Scanner scanner = new Scanner(System.in);
        List<String> answerList = consoleChat.listAnswer;
        File logFile = new File(consoleChat.pathLog);
        consoleChat.chat(scanner, answerList, logFile);
    }

    /**
     * Implementation of communication.
     * @param scanner Questions.
     * @param answerList Answers.
     * @param logFile File to save the text of correspondence.
     */
    public void chat(Scanner scanner, List<String> answerList, File logFile) {
        System.out.println("List of commands: " + LIST_COMMANDS);
        if (logFile.exists()) {
            logFile.delete();
        }
        String myMessage = null;
        boolean stop = false;
        do {
            StringBuilder textLog = new StringBuilder();
            myMessage = scanner.nextLine();
            textLog.append(myMessage);
            if (!myMessage.equals(EXIT)) {
                if (!stop && myMessage.equals(STOP)) {
                    stop = true;
                } else if (stop && myMessage.equals(CONTINUE)) {
                    stop = false;
                } else if (!stop) {
                    String answer = answerComp(answerList);
                    System.out.println(answer);
                    textLog.append(System.lineSeparator()).append(answer);
                }
            }
            recordLog(logFile, textLog.toString());
        } while (!myMessage.equals(EXIT));
    }

    /**
     * A random string from the collection.
     * @param list Collection with strings.
     * @return Random string.
     */
    private String answerComp(List<String> list) {
        int size = list.size();
        int rnd = (int) (Math.random() * size);
        return size > 0 ? list.get(rnd) : "The answer file is empty.";
    }

    /**
     * Adds lines of a text file to the collection.
     * @param pathAnswer Path to the answer file.
     * @return Collection of answers.
     */
    private List<String> fileToArray(String pathAnswer) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufRead = new BufferedReader(new FileReader(pathAnswer))) {
            String line = null;
            while ((line = bufRead.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }

    /**
     * Record the history of the conversation in the log file.
     * @param logFile Log-file.
     * @param log A string to write to the log.
     */
    private void recordLog(File logFile, String log) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(logFile, true))) {
            br.write(log);
            br.newLine();
            br.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
