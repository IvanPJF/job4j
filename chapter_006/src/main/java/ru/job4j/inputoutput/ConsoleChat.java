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
    private static final List<String> LIST_COMMANDS = new ArrayList<>(Arrays.asList(STOP, CONTINUE, EXIT));
    private String pathAnswer;
    private String pathLog;

    public ConsoleChat(String[] args) {
        this.pathAnswer = args[0];
        this.pathLog = args[1];
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat(args);
        File answerFile = new File(consoleChat.pathAnswer);
        File logFile = new File(consoleChat.pathLog);
        consoleChat.chat(answerFile, logFile);
    }

    /**
     * Implements communication in the console.
     * @param answerFile File with ready-made answers.
     * @param logFile File to record a conversation.
     */
    private void chat(File answerFile, File logFile) {
        System.out.println("List of commands: " + LIST_COMMANDS);
        Scanner scanner = new Scanner(System.in);
        String myMessage = null;
        boolean stop = false;
        do {
            StringBuilder textLog = new StringBuilder();
            myMessage = scanner.nextLine();
            textLog.append("My message: ").append(myMessage);
            if (!myMessage.equals(EXIT)) {
                if (!stop && myMessage.equals(STOP)) {
                    stop = true;
                } else if (stop && myMessage.equals(CONTINUE)) {
                    stop = false;
                } else if (!stop) {
                    String answer = answerComp(answerFile);
                    System.out.println(answer);
                    textLog.append(System.lineSeparator()).append("Computer message: ").append(answer);
                }
            }
            recordLog(logFile, textLog.toString());
        } while (!myMessage.equals(EXIT));
    }

    /**
     * Select a random response from a special file.
     * @param file A file with a list of answers.
     * @return Random response from file.
     */
    private String answerComp(File file) {
        String result = null;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            String firstLine = raf.readLine();
            long size = raf.length();
            long rnd = (long) (Math.random() * size);
            if (firstLine != null && rnd <= firstLine.length()) {
                result = firstLine;
            } else if (firstLine != null) {
                result = randomLine(raf, rnd);
            } else {
                result = "The answer file is empty.";
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }

    /**
     * Select a random string from a file.
     * @param raf Open file with a list of answers.
     * @param position The position at which the string search begins.
     * @return Random string.
     * @throws IOException IOException.
     */
    private String randomLine(RandomAccessFile raf, long position) throws IOException {
        raf.seek(position);
        raf.readLine();
        String result = raf.readLine();
        if (result == null) {
            raf.seek(0);
            result = raf.readLine();
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
