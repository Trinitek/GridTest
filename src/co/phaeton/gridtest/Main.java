package co.phaeton.gridtest;

import co.phaeton.gridtest.log.LogStream;
import co.phaeton.gridtest.log.LogType;
import co.phaeton.gridtest.log.Logger;
import co.phaeton.gridtest.render.Render;
import co.phaeton.gridtest.render.RenderGridLines;
import co.phaeton.gridtest.render.RenderTiles;
import co.phaeton.gridtest.render.WindowFrame;

public class Main {

    public static void main(String[] args) {
        Logger logger = new Logger();
        LogStream logStream = new LogStream(logger, "Main");

        logStream.log(LogType.INFO, "Hello world!");

        MapGrid mapgrid = new MapGrid(20, 10, false, false);

        WindowFrame window = new WindowFrame();

        Render render = new Render(logger, window);
        render.getComponentList().add(new RenderTiles(logger, mapgrid));
        render.getComponentList().add(new RenderGridLines(mapgrid));
        render.start();

        for (int y = 0; y < mapgrid.getHeight(); y++) {
            for (int x = 0; x < mapgrid.getWidth(); x++) {
                switch (mapgrid.getTerrain()[x][y]) {
                    case GRASS:
                        System.out.print("#");
                        break;
                    case OCEAN:
                        System.out.print("_");
                }
            }
            System.out.println();
        }
    }

}
