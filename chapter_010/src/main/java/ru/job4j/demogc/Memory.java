package ru.job4j.demogc;

import java.util.StringJoiner;

public class Memory {
    private static final Runtime RUNTIME = Runtime.getRuntime();
    private static final String LS = System.lineSeparator();

    private static class User {
        private int age;
        private String name;

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.print("Killed object");
        }
    }

    public static void main(String[] args) {
        int count = 0;
        int size = 1024 * 8;
        info();
        double freeMemoryBefore = getFreeMemoryKb();
        for (int i = 0; i < size; i++) {
            count++;
            new User();
        }
        double freeMemoryAfter = getFreeMemoryKb();
        info();
        StringJoiner joiner = new StringJoiner(LS);
        joiner
                .add(String.format("%nWeight all objects:%11.3f", freeMemoryBefore - freeMemoryAfter))
                .add(String.format("Weight one object: %11.3f", (freeMemoryBefore - freeMemoryAfter) / count));
        System.out.println(joiner.toString());
    }

    private static void info() {
        double kb = 1024.0;
        StringJoiner joiner = new StringJoiner(LS);
        joiner
                .add(String.format("%nHEAP - info [KB]"))
                .add(String.format("Max memory:        %11.3f", RUNTIME.maxMemory() / kb))
                .add(String.format("Total memory:      %11.3f", RUNTIME.totalMemory() / kb))
                .add(String.format("Use memory:        %11.3f", (RUNTIME.totalMemory() - RUNTIME.freeMemory()) / kb));
        System.out.println(joiner.toString());
    }

    private static double getFreeMemoryKb() {
        return RUNTIME.freeMemory() / 1024.0;
    }
}
