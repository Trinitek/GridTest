package co.phaeton.gridtest.render;

import co.phaeton.gridtest.log.LogStream;
import co.phaeton.gridtest.log.LogType;
import co.phaeton.gridtest.log.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Render implements Runnable {

    private LogStream logStream;
    private Thread thread;
    private WindowFrame window;
    private ArrayList<JComponent> componentList;
    private volatile boolean execute;

    public Render(Logger logger, WindowFrame window) {
        this.logStream = new LogStream(logger, "Render");
        this.thread = new Thread(this);
        this.window = window;
        this.componentList = new ArrayList<>();
    }

    @Override
    public void run() {
        this.execute = true;
        while (this.execute) {
            try {
                Graphics2D graphics2D = (Graphics2D) this.window.getBufferStrategy().getDrawGraphics();
                graphics2D.translate(this.window.getInsets().left, this.window.getInsets().top);

                for (JComponent component : componentList) {
                    component.paint(graphics2D);
                }

                window.getBufferStrategy().show();

            } catch (IllegalStateException e) {
                this.logStream.log(LogType.WARN, "Buffer hasn't been created?");
            }

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.execute = false;
            }
        }
    }

    public void start() {
        this.thread.start();
    }

    public void stop() {
        this.execute = false;
    }

    public ArrayList<JComponent> getComponentList() {
        return this.componentList;
    }

}
