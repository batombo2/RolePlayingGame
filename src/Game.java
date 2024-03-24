import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static final int GoblinStrength = 20;
    public static final int GoblinDexterity = 10;
    public static final int SkeletonStrength = 15;
    public static final int SkeletonDexterity = 15;
    public static final int HeroStrength = 20;
    public static final int HeroDexterity = 20;

    private Hero hero;
    private Monster monster;
    private Trader trader;
    private Battle battle;
    private boolean aliveFlag= true;
    private final String strHi = "Приветствую, игрок %s.";
    private final String strStatus = "Статус игрока： жизнь:%d сила:%d золото:%d опыт:%d ловкость:%d.%n";

    public void run() {
       char cmd;
       boolean flag = true;
       String heroName;

       try ( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ) {
           System.out.print("Имя игрока: ");
           heroName = reader.readLine();
           hero = new Hero(heroName , HeroStrength , HeroDexterity);
           greeting(hero);

           while (flag) {
               showStatus(hero);
               System.out.print("К торговцу / В тёмный лес / На выход - Ваш выбор( 1/2/3) : " );
               cmd = (char) reader.read();
               reader.readLine(); // consume the newline character

               switch (cmd){
                   case '3':
                   case 'q':
                   case 'Q':
                       System.out.println("     Выхожу из игры.");
                       flag=false;
                       break;
                   case '2':
                       System.out.println(" Герой идет в лес и встечает монстра.");
                       monster = createMonster();
                       battle = new Battle(hero,monster,this);
                       battle.start();
                       try {
                           battle.join();
                       } catch (InterruptedException e) {
                           System.out.println(e);
                       }
                       if(!aliveFlag){
                           System.out.println("     Герой убит - игра закончена.");
                           flag=false;
                       }
                       break;
                   case '1':
                       System.out.println(" Герой идёт к торговцу купить здоровья ( за золото)");
                       Trader.bargain(hero);
                       Thread.sleep(1000);
                       break;
               }
           }
       }catch (IOException e){
           System.out.println(e);
           //System.out.println(" something wrong in Game.run()");
       } catch (InterruptedException e) {
           System.out.println(e);
       }

    }

    private void greeting(Hero hero){
        System.out.println( String.format(strHi , hero.getName() ));
        //showStatus(hero);
    }

    private void showStatus(Hero hero){
        System.out.println(String.format(strStatus, hero.getHealth(), hero.getStrength(),
                hero.getGold() , hero.getExperience() ,hero.getDexterity()));

    }
    public void setDeadFlag(){
        aliveFlag = false;
    }

    private Monster createMonster(){

        return ( Math.random()>0.5 ) ?   new Goblin(): new Skeleton();
    }
}
