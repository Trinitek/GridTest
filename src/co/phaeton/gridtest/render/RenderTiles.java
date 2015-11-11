package co.phaeton.gridtest.render;

import co.phaeton.gridtest.MapGrid;
import co.phaeton.gridtest.Terrain;
import co.phaeton.gridtest.log.LogStream;
import co.phaeton.gridtest.log.LogType;
import co.phaeton.gridtest.log.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class RenderTiles extends JComponent {

    private LogStream logStream;
    private MapGrid mapGrid;

    public RenderTiles(Logger logger, MapGrid mapGrid) {
        this.logStream = new LogStream(logger, "RenderTiles");
        this.mapGrid = mapGrid;
    }

    public void paint(Graphics g) {
        g.drawString("Hello world...", 0, 20);

        for (int x = 0; x < this.mapGrid.getWidth(); x++)
            for (int y = 0; y < this.mapGrid.getHeight(); y++)
                g.drawImage(
                        this.mapGrid.getTerrain()[x][y].getImage(),
                        x * MapGrid.GRID_RESOLUTION_WIDTH,
                        y * MapGrid.GRID_RESOLUTION_HEIGHT,
                        MapGrid.GRID_RESOLUTION_WIDTH,
                        MapGrid.GRID_RESOLUTION_HEIGHT,
                        null);
    }

}
