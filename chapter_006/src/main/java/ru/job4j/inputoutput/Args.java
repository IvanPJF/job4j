package ru.job4j.inputoutput;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Args {

    private String path;
    private List<String> exclude;
    private String output;

    public Args(String[] args) {
        this.parser(args);
    }

    private void parser(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(args));
        while (!list.isEmpty()) {
            String key = list.poll();
            if (key.equals("-d") && this.path == null) {
                this.path = list.poll();
            } else if (key.equals("-o") && this.output == null) {
                this.output = list.poll();
            } else if (key.equals("-e") && this.exclude == null) {
                this.exclude = new LinkedList<>();
                String value = list.element();
                while (!list.isEmpty() && !value.equals("-d") && !value.equals("-o")) {
                    this.exclude.add(list.poll());
                    value = list.element();
                }
            } else {
                System.out.println("Не верно указаны параметры : java -jar name.jar -d path -e exclude -o outPath.zip");
                break;
            }
        }
    }

    private void toDir(File file, String relatPath, ZipOutputStream zout) {
        String path = relatPath + file.getName() + "/";
        toZip(file, path, zout);
        if (file.isDirectory()) {
            for (File value : file.listFiles()) {
                if (value.isDirectory()) {
                    toDir(value, path, zout);
                } else {
                    toZip(value, path, zout);
                }
            }
        }
    }

    private void toZip(File file, String relatPath, ZipOutputStream zout) {
        if (file.isDirectory()) {
            try {
                zout.putNextEntry(new ZipEntry(relatPath));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else if (this.exclude(this.exclude, file)) {
            write(file, relatPath, zout);
        }
    }

    private void write(File file, String relatPath, ZipOutputStream zout) {
        int sizeBuffer = 1024;
        int length = -1;
        byte[] buff = new byte[sizeBuffer];
        try (InputStream is = new FileInputStream(file)) {
            zout.putNextEntry(new ZipEntry(relatPath + file.getName()));
            while ((length = is.read(buff)) != -1) {
                zout.write(buff, 0, length);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String directory() {
        return this.path;
    }

    private boolean exclude(List<String> exclude, File file) {
        boolean result = true;
        if (exclude != null) {
            for (String value : exclude) {
                if (file.getName().endsWith(value)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public String output() {
        return this.output;
    }

    private void run() throws IOException {
        if (this.path != null && this.exclude != null && this.output != null) {
            File file = new File(this.path);
            String relatPath = "";
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(this.output()));
            this.toDir(file, relatPath, zout);
            zout.flush();
            zout.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new Args(args).run();
    }
}
