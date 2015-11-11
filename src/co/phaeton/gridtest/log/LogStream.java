package co.phaeton.gridtest.log;

public class LogStream {

    private Logger logger;
    private String title;

    public LogStream(Logger logger, String title) {
        this.logger = logger;
        this.title = title;
    }

    public void log(LogType type, String message) {
        if ((type == LogType.INFO && logger.allowsInfo()) ||
            (type == LogType.WARN && logger.allowsWarn()) ||
            (type == LogType.ERROR && logger.allowsError()))
        System.out.println(type.toString() + ": " + this.title + ": " + message);
    }

}
