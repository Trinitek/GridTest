package co.phaeton.gridtest.log;

public class LogStream {

    private Logger logger;
    private String title;

    public LogStream(Logger logger, String title) {
        this.logger = logger;
        this.title = title;
    }

    public void log(LogType type, String message) {
        if ((type == LogType.INFO && logger.info) ||
            (type == LogType.WARN && logger.warn) ||
            (type == LogType.ERROR && logger.error))
        System.out.println(type.toString() + ": " + this.title + ": " + message);
    }

}
