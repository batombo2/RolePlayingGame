public class Hero extends Role{

    private int level;
    private int experience;
    private int gold;

    public int getLevel() {
        return level;
    }

    public  int getExperience(){
        return experience;
    }

    public  int getGold(){
        return gold;
    }

    public Hero(String name, int strength , int dexterity){
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        level =0;
        experience =0;
        gold =0;
        this.health = 100;
    }

    public int increaseLevel(int experience) {
        return ++level;
    }



    public void increaseHealth(int health ) {
        this.health += health;
    }

    public void increaseGold(int gold){
        this.gold += gold;
    }

    public void decreaseGold(int gold){
        this.gold -= gold;
        this.gold = Math.max( 0 , this.gold);

    }

    public void increaseExperience(int experience){
        this.experience += experience;
    }


}
