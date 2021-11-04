/**
 * @author You Peng
 * @date 11/3/2021 7:36 PM
 */

public enum TileType {
    COMMON(" "),
    MARKET("M"),
    INACCESSIBLE("0"),
    TEAM("X")
    ;


    private final String text;

    TileType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
