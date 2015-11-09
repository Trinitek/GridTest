package co.phaeton.gridtest.render;

import co.phaeton.gridtest.MapGrid;

import javax.swing.*;
import java.awt.*;

public class RenderGridLines extends JComponent {

    private MapGrid mapGrid;

    public RenderGridLines(MapGrid mapGrid) {
        this.mapGrid = mapGrid;
    }

    public void paint(Graphics g) {
        int i;
        for (i = 0;
             i <= MapGrid.GRID_RESOLUTION_HEIGHT * this.mapGrid.getHeight();
             i += MapGrid.GRID_RESOLUTION_HEIGHT)
            g.drawLine(0, i, this.mapGrid.getWidth() * MapGrid.GRID_RESOLUTION_WIDTH, i);
        for (i = 0;
             i <= MapGrid.GRID_RESOLUTION_WIDTH * this.mapGrid.getWidth();
             i += MapGrid.GRID_RESOLUTION_WIDTH)
            g.drawLine(i, 0, i, this.mapGrid.getHeight() * MapGrid.GRID_RESOLUTION_HEIGHT);
    }

}
