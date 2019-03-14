package ru.job4j.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsageLog4j {

    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int version = 1;
        LOG.trace("trace message {}", version);
        LOG.debug("debug message {}", version);
        LOG.info("info message {}", version);
        LOG.warn("warn message {}", version);
        LOG.error("error message {}", version);
    }
}
