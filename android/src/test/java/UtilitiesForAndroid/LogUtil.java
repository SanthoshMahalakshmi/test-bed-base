package UtilitiesForAndroid;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtil {
    private static final Logger logger = Logger.getLogger(LogUtil.class.getName());

    static {
        // Custom ConsoleHandler with auto-flush on every log
        ConsoleHandler consoleHandler = new ConsoleHandler() {
            @Override
            public synchronized void publish(java.util.logging.LogRecord record) {
                super.publish(record);
                flush(); // 🔥 Flush immediately after every log
            }
        };

        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new CustomFormatter());

        logger.setUseParentHandlers(false); // prevent root logger duplication
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
    }

    public static void info(String msg) {
        logger.info(msg);
        System.out.flush(); // backup flush
    }

    public static void warning(String msg) {
        logger.warning(msg);
        System.out.flush();
    }

    public static void error(String msg) {
        logger.severe(msg);
        System.out.flush();
    }

    public static Logger getLogger(String name) {
        return null;
    }
}
