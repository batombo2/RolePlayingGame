public class Skeleton extends Monster{

    public Skeleton(){
        goldReward = 20;
        experienceReward =1;
        name = "Skeleton:" + generateRandomString(5);
        health = 100;
        strength = Game.SkeletonStrength;  //
        dexterity = Game.SkeletonDexterity; // random
    }
    public void greeting(){
        System.out.printf(" Привет, я монстр-скелет  %s  моя сила %d , моя ловкость %d%n",name ,strength,dexterity);
        System.out.println("    Щас зашибу!");
    }
}
