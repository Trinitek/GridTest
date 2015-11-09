package co.phaeton.gridtest.render;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Render implements Runnable {

    private Thread thread;
    private WindowFrame window;
    private ArrayList<JComponent> componentList;
    private volatile boolean execute;

    public Render(WindowFrame window) {
        this.thread = new Thread(this);
        this.window = window;
        this.componentList = new ArrayList<>();
    }

    @Override
    public void run() {
        this.execute = true;
        while (this.execute) {
            Graphics2D graphics2D = (Graphics2D) this.window.getBufferStrategy().getDrawGraphics();

            for (JComponent component : componentList) {
                component.paint(graphics2D);
            }

            window.getBufferStrategy().show();

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
