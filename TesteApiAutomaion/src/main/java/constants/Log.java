package constants;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void info(String mensagem) {
        LOGGER.log(Level.INFO, mensagem);
    }
}

