/**
 * @author You Peng
 * @date 11/3/2021 7:13 PM
 */

public class LegendWorld extends World {

    private final static String MARKET_TILE = String.format("\u001B[34m%s\u001B[0m", TileType.MARKET);
    private final static String COMMON_TILE = TileType.COMMON.toString();
    private final static String INACCESSIBLE_TILE = TileType.INACCESSIBLE.toString();
    private final static String TEAM_TILE = String.format("\u001B[31m%s\u001B[0m", TileType.TEAM);

    protected int teamX;
    protected int teamY;
    protected String teamTile;

    /**
     * Generate the world
     */
    @Override
    public void generate() {
        int total = this.width * this.height;
        int inaccessible = (int) Math.round(total * 0.2);
        int market = (int) Math.round(total * 0.3);
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                double randNum = Math.random();
                if (randNum < 0.2 && inaccessible > 0) {
                    this.map[i][j] = INACCESSIBLE_TILE;
                    inaccessible -= 1;
                } else if (inaccessible > 0 && randNum < 0.6 && market > 0) {
                    this.map[i][j] = MARKET_TILE;
                    market -= 1;
                } else if (randNum < 0.5 && market > 0) {
                    this.map[i][j] = MARKET_TILE;
                    market -= 1;
                } else {
                    this.map[i][j] = COMMON_TILE;
                }
            }
        }
        // Set Team pos
        this.setTile(this.teamX, this.teamY, TEAM_TILE);
    }

    /**
     * Update the position of the team
     */
    public void setTeamLocation(int x, int y) {
        updateMap(x, y);
        this.teamX = x;
        this.teamY = y;

    }

    /**
     * Update the map signs
     */
    public void updateMap(int x, int y) {
        // refill old tile
        this.setTile(this.teamX, this.teamY, this.teamTile);
        // Store mark on occupied tile
        this.teamTile = getTile(x, y);
        // Change mark on new tile
        this.setTile(x, y, TEAM_TILE);
    }

    /**
     * Check tile is inaccessible
     */
    public boolean isInaccessible(int x, int y) {
        return this.map[x][y].equals(INACCESSIBLE_TILE);
    }

}
