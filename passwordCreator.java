import java.lang.reflect.Array;
import java.util.ArrayList;

public class passwordCreator{
    public static void main(String[] args) throws InterruptedException {
        String response;
        String wordsForPassword [];
        ArrayList<String> wordsForPasswordArray;
        ArrayList<Character> password;
        int passwordLength;

        utilFunctions.welcomeAnimation();
        utilFunctions.explaningAnimation();

        response = utilFunctions.getStarted();

        if(response.equals("N")){
            System.exit(-1);
        }
        else{
            wordsForPassword = utilFunctions.introduceWords().split(" ");

            wordsForPasswordArray = new ArrayList<>();
            for(int i = 0; i < wordsForPassword.length; i++){
                wordsForPasswordArray.add(wordsForPassword[i]);
            }

            passwordLength = utilFunctions.choosingPasswordLength();
            utilFunctions.checkAndBuild(wordsForPasswordArray, passwordLength);

            password = new ArrayList<>();

            System.out.print("\n\t\t\tCALCULATING PASSWORD");
            for(int i = 0; i < 3; i++){
                Thread.sleep(1000);
                System.out.print(".");
            }

            long t1 = System.currentTimeMillis();
            password = utilFunctions.getPassword(wordsForPasswordArray, passwordLength);
            long t2 = System.currentTimeMillis();

            System.out.println("\n\t\t\tTIME TO CALCULATE: " + (t2 - t1)/1000 + " SECONDS");
            System.out.print("\n\t\t\t" + "PASSWORD: ");

            for(Character letter: password){
                System.out.print(letter);
            }
        }
    }
}