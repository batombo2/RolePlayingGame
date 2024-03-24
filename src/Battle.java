public class Battle extends Thread{
    private Hero hero;
    private Monster monster;

    private Game game;

    public Battle(Hero hero ,Monster monster, Game game){
        this.hero = hero;
        this.monster = monster;
        this.game = game;
    }
    @Override
    public void run(){
        boolean flag = true;

        monster.greeting();
        System.out.println("     Битва началась.");


        while (true){
            if( hero.attack(monster) ){
                System.out.printf("Монстр убит. Герой получает золота %d и опыта %d.%n" ,
                        monster.getGoldReward() , monster.getExperienceReward());

                hero.increaseGold(monster.getGoldReward());
                hero.increaseExperience(monster.getExperienceReward());

                break;
            }
            try { sleep(1000); } catch (InterruptedException e) { System.out.println(e);}
            if( monster.attack(hero) ){
                System.out.println("Герой погибнул.");
                game.setDeadFlag(); //the game should know - the hero is dead
                break;
            }
            try { sleep(1000); } catch (InterruptedException e) { System.out.println(e);}
        }


        //hero.
    }
}
