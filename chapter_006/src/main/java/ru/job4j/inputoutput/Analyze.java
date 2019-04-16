package ru.job4j.inputoutput;

import java.io.*;
import java.util.*;

/**
 * Server operation analysis.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 16.04.2019
 *@version 0.1
 */
public class Analyze {

    private static final String SP = " ";
    private final List<String> types = Arrays.asList("400", "500");
    private final Deque<String> outList = new LinkedList<>();

    /**
     * Write the found ranges to the target file.
     * @param source Log file.
     * @param target Target file.
     */
    public void unavailable(String source, String target) {
        this.diapasonToDeque(source);
        try (PrintWriter write = new PrintWriter(new FileOutputStream(target))) {
            while (!this.outList.isEmpty()) {
                write.println(this.outList.pollFirst());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Search in the log file for time ranges at the moment when the server was not working.
     * @param source Log file.
     */
    private void diapasonToDeque(String source) {
        try (Scanner read = new Scanner(new FileReader(source))) {
            String timeStop = null;
            boolean isStop = false;
            while (read.hasNextLine()) {
                String[] arrTypeTime = read.nextLine().split(SP);
                String status = arrTypeTime[0].trim();
                String time = arrTypeTime[1].trim();
                if (isStop) {
                    if (!this.types.contains(status) || !read.hasNextLine()) {
                        this.outList.add(String.format("%s;%s", timeStop, time));
                        isStop = false;
                    }
                } else {
                    if (this.types.contains(status) && read.hasNextLine()) {
                        timeStop = time;
                        isStop = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
