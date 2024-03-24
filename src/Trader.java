import java.sql.SQLOutput;

public class Trader {
    public static  void bargain(Hero hero){
        boolean flag = true;

        if (hero.getGold() <10){
            System.out.println("  Торговец говорит : У тебя мало золота , уходи.");
            flag = false;
        } else if ( hero.getHealth() >= 100){
            System.out.println("  Торговец говорит :  У тебя зоровье в порядке , уходи.");
            flag = false;
        }

        if(flag){
            System.out.println("  Торговец говорит :  Получи 10 жизни за 10 золота.");
            hero.decreaseGold(10);
            hero.increaseHealth(10);

        }


    }

}
