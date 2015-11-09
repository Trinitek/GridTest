package co.phaeton.gridtest;

import co.phaeton.gridtest.render.Render;
import co.phaeton.gridtest.render.RenderGridLines;
import co.phaeton.gridtest.render.RenderTile;
import co.phaeton.gridtest.render.WindowFrame;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        MapGrid mapgrid = new MapGrid(20, 10, false, false);

        WindowFrame window = new WindowFrame();

        Render render = new Render(window);
        render.getComponentList().add(new RenderTile());
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
