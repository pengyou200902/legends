/**
 * @author You Peng
 * @date 11/3/2021 7:11 PM
 */

public abstract class World {
    protected String[][] map;
    protected int width;
    protected int height;

    public World() {
        width = 8;
        height = 8;
        map = new String[width][height];
    }

    public World(int width, int height) {
        this.map = new String[width][height];
        this.width = width;
        this.height = height;
    }

    public abstract void generate();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTile(int x, int y) {
        return map[x][y];
    }

    public void setTile(int x, int y, String tile) {
        map[x][y] = tile;
    }

    public void printMap() {
        System.out.println();
        System.out.println("---------------------------------");
        for (int i = 0; i < this.width; i++) {
            System.out.print("|");
            for (int j = 0; j < this.height; j++) {
                System.out.print(" " + this.map[j][i] + " |");
            }
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println();
        }
    }

}
