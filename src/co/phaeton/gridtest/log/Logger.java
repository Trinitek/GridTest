package co.phaeton.gridtest.log;

public class Logger {

    private boolean info;
    private boolean warn;
    private boolean error;

    public Logger() {
        this.info = true;
        this.warn = true;
        this.error = true;
    }

    public boolean allowsInfo() {
        return info;
    }

    public void setInfo(boolean info) {
        this.info = info;
    }

    public boolean allowsWarn() {
        return warn;
    }

    public void setWarn(boolean warn) {
        this.warn = warn;
    }

    public boolean allowsError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
