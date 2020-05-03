package logger;

import org.apache.log4j.Logger;

public class LoggerApp {

    private static Logger logger = Logger.getRootLogger();
    private static LoggerApp instance = null;

    public LoggerApp() {
    }

    public static synchronized LoggerApp getInstance() {
        if (instance == null) {
            instance = new LoggerApp();
        }
        return instance;
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }
}