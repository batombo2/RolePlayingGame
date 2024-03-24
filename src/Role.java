public abstract class Role {
    protected String name;
    protected int health;
    protected int strength;
    protected int dexterity;




    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength(){
        return strength;
    }

    public  int getDexterity(){
        return dexterity;
    }

    // get wounded
    protected int wound(int health) {
        this.health = Math.max( 0 , this.health - health);
        return this.health;
    }

    // returns true if the victim is killed
    public boolean attack(Role victim){
        boolean result = false;

        System.out.printf(" %s наносит удар по %s%n ", name , victim.getName());

        if( (dexterity*3) > (Math.random()*100) ){
            System.out.print(" -   Удачный удар ," );

            if (victim.wound( strength)==0) {
                System.out.println("    У Б И Л ");
                result = true;
            }else {
                System.out.printf("сила удара %d,  осталось жизни %d%n", strength , victim.getHealth());
            }
        }else{
            System.out.println("    Промах!!");
        }
        return result;
    }

}
