package co.phaeton.gridtest.render;

import javax.swing.*;
import java.awt.*;

public class RenderTile extends JComponent {

    public void paint(Graphics g) {
        g.drawString("Hello world...", 0, 20);
    }

}
