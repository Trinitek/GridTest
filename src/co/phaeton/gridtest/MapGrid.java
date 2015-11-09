package co.phaeton.gridtest;

import java.util.Random;

public class MapGrid {

    public static final int GRID_RESOLUTION_WIDTH = 64;
    public static final int GRID_RESOLUTION_HEIGHT = 64;

    private int width, height;
    private boolean wrapX, wrapY;
    private Terrain[][] terrain;

    public MapGrid(int width, int height, boolean wrapX, boolean wrapY) {
        this.width = width;
        this.height = height;
        this.wrapX = wrapX;
        this.wrapY = wrapY;
        this.terrain = new Terrain[width][height];
        generateMap();
    }

    public void generateMap() {
        Random random = new Random();
        for (int x = 0; x < this.width; x++)
            for (int y = 0; y < this.height; y++)
                this.terrain[x][y] = random.nextBoolean() ? Terrain.GRASS : Terrain.OCEAN;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getWrapX() {
        return this.wrapX;
    }

    public boolean getWrapY() {
        return this.wrapY;
    }

    public Terrain[][] getTerrain() {
        return this.terrain;
    }

}
