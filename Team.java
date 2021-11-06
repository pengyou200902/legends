import java.util.ArrayList;

/**
 * @author You Peng
 * @date 11/6/2021 3:49 PM
 */


public abstract class Team {

    protected ArrayList<BaseCharacter> characters;

    public Team() {
        this.characters = new ArrayList<>();
    }

    // add
    public void addCharacter(BaseCharacter character){
        this.characters.add(character);
    }

    // find by id
    public BaseCharacter getCharacter(int index){
        return this.characters.get(index);
    }

    // remove by obj
    public void removeCharacter(BaseCharacter character){
        this.characters.remove(character);
    }
    
    // remove by id
    public void removeCharacter(int index){
        this.characters.remove(index);
    }

    // team size
    public int size(){
        return this.characters.size();
    }

    // print team info
    public abstract void printTeam();
    
}
