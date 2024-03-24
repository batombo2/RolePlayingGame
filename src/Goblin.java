public class Goblin extends Monster{

    public Goblin(){
        goldReward = 10;
        experienceReward =1;
        name = "Goblin:" + generateRandomString(6);
        health = 100;
        strength = Game.GoblinStrength;  //
        dexterity = Game.GoblinDexterity; // random
    }
    public void greeting(){
        System.out.printf(" Я монстр-гоблин  %s . Моя сила %d , моя ловкость %d.%n",name ,strength,dexterity);
        System.out.println("   Убью и сьем !!");

    }

}
