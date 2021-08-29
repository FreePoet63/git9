package listener;

import ch.qos.logback.core.FileAppender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.routing.RoutingAppender;

public abstract class AllureLogger {
    private static final Logger Log =  LogManager.getLogger(AllureLogger.class);

    public static void info (String message) {
        Log.info(message);
    }

    public static void warn (String message) {
        Log.warn(message);
    }

    public static void error (String message) {
        Log.error(message);
    }

    public static void fatal (String message) {
        Log.fatal(message);
    }

    public static void debug (String message) {
        Log.debug(message);
    }
}
