package ru.job4j.find;

import org.apache.commons.cli.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

/**
 * File search.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 31.03.2019
 *@version 0.1
 */
public class Find {

    private Options options;
    private String root;
    private String name;
    private String out;
    private boolean mask;
    private boolean full;

    public Find(String[] args) {
        this.options = this.createOptions();
        this.parse(args);
    }

    /**
     * The creation of the key arguments for the console launch.
     * @return Keyset.
     */
    private Options createOptions() {
        OptionGroup optGroup = new OptionGroup();
        optGroup.addOption(new Option("m", false, "Search by mask"));
        optGroup.addOption(new Option("f", false, "Search by full name"));
        Options options = new Options();
        options.addOption(new Option("d", true, "Root directory"));
        options.addOption(new Option("n", true, "Name of the file"));
        options.addOption(new Option("o", true, "A file with the search result"));
        options.addOptionGroup(optGroup);
        return options;
    }

    /**
     * Parser for command line.
     * @param args Command line argument.
     */
    private void parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(this.options, args);
            this.assignValues(commandLine);
        } catch (ParseException e) {
            e.getMessage();
        }
    }

    /**
     * Assign values to fields corresponding to command-line keys.
     * @param commandLine A set of values that correspond to command-line switches.
     */
    private void assignValues(CommandLine commandLine) {
        this.root = commandLine.getOptionValue("d");
        this.name = commandLine.getOptionValue("n");
        this.out = commandLine.getOptionValue("o");
        if (commandLine.hasOption("m")) {
            this.mask = true;
        } else if (commandLine.hasOption("f")) {
            this.full = true;
        }
    }

    /**
     * Adds all files in the specified directory to the list.
     * @param rootDir Root directory.
     * @return File list.
     */
    public LinkedList<File> allFiles(String rootDir) {
        LinkedList<File> list = new LinkedList<>();
        LinkedList<File> files = new LinkedList<>();
        File file = new File(rootDir);
        list.push(file);
        while (!list.isEmpty()) {
            file = list.poll();
            if (file.isDirectory()) {
                for (File value : file.listFiles()) {
                    if (value.isDirectory()) {
                        list.push(value);
                    } else {
                        files.push(value);
                    }
                }
            } else {
                files.push(file);
            }
        }
        return files;
    }

    /**
     * Search for files in the file list by certain criteria(full name, mask).
     * @param allFiles File list.
     * @param findName Name to search.
     * @return List of found files.
     */
    public List<File> find(LinkedList<File> allFiles, String findName) {
        List<File> result = new LinkedList<>();
        if (this.full) {
            for (File file : allFiles) {
                if (file.getName().equals(findName)) {
                    result.add(file);
                }
            }
        } else if (this.mask) {
            for (File file : allFiles) {
                String endWord = findName.substring(1);
                if (file.getName().endsWith(endWord)) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    /**
     * The template is the correct spelling of arguments.
     * @return Hint.
     */
    private String info() {
        return "Incorrect arguments: java -jar find.jar -d path -n file or mask -m -o log.txt "
                + "(replace -m(mask) with -f(full) if you search for the full name)";
    }

    private boolean isValidFields() {
        return this.root != null
                && this.name != null
                && this.out != null
                && (this.mask || this.full);
    }

    /**
     * Write the paths of the found files to the log file.
     */
    public void run() {
        if (this.isValidFields()) {
            List<File> list = this.find(this.allFiles(this.root), this.name);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(this.out)))) {
                for (File file : list) {
                    bw.write(file.getAbsolutePath());
                    bw.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(this.info());
        }
    }

    public static void main(String[] args) {
        new Find(args).run();
    }
}
