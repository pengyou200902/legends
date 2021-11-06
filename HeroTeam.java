/**
 * @author You Peng
 * @date 11/6/2021 3:53 PM
 */


public class HeroTeam extends Team {
    protected int x;
    protected int y;

    public HeroTeam() {
        super();
        this.x = 0;
        this.y = 0;
    }

    public HeroTeam(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    // moves
    public void goUp() {
        this.y -= 1;
    }

    public void goDown() {
        this.y += 1;
    }

    public void goLeft() {
        this.x -= 1;
    }

    public void goRight() {
        this.x += 1;
    }

    // getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void printTeam() {

    }


}
