package co.phaeton.gridtest.render;

import javax.swing.*;

public class WindowFrame extends JFrame {

    private JFrame frame;

    public WindowFrame() {
        this.setTitle("MapGrid Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.setVisible(true);
    }

}
