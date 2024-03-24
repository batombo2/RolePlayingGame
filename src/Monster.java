import java.util.Random;

public abstract class Monster extends Role{
    protected static int goldReward;
    protected static int experienceReward;
    public int getGoldReward(){
        return goldReward;
    }
    public  int getExperienceReward(){
        return experienceReward;
    }
    public abstract void greeting();


    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }


}
