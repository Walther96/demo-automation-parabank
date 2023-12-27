package pe.personal.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerManager {

    private TimerManager(){}
    private static final Logger LOGGER = LoggerFactory.getLogger(TimerManager.class);

    public static void waitTime(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}