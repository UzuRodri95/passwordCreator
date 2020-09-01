import java.util.*;

public class utilFunctions{
    public static void welcomeAnimation() throws InterruptedException {
        String title = "PASSWORD GENERATOR v1.0";

        System.out.print("\n\n\t\t");
        for(int i = 0; i <= 100; i++){
            System.out.print("#");
            Thread.sleep(20);
        }
        System.out.print("\n\t\t");
        for(int i = 0; i <= 36; i++){
            System.out.print("#");
            Thread.sleep(20);
        }
        System.out.print("  ");
        for(int i = 0; i <= title.length() - 1; i++){
            System.out.print(title.charAt(i));
            Thread.sleep(100);
        }
        System.out.print("  ");
        for(int i = 0; i <= 36; i++){
            System.out.print("#");
            Thread.sleep(20);
        }
        System.out.print("\n\t\t");
        for(int i = 0; i <= 100; i++){
            System.out.print("#");
            Thread.sleep(20);
        }
        System.out.print("\n");
    }

    public static void explaningAnimation() throws InterruptedException {
        String exp1 = "1. Welcome to PASSWORD GENERATOR, a simple program that will give you a password given a few words.";
        String exp2 = "2. You will be able to choose between 8 and 16 length formats.";
        String exp3 = "3. After introducing the words and choosing the length format, the password will be displayed.";

        System.out.print("\n\t\t");
        for(int i = 0; i <= exp1.length() - 1; i++){
            System.out.print(exp1.charAt(i));
            Thread.sleep(50);
        }
        System.out.print("\n\t\t");
        for(int i = 0; i <= exp2.length() - 1; i++){
            System.out.print(exp2.charAt(i));
            Thread.sleep(50);
        }
        System.out.print("\n\t\t");
        for(int i = 0; i <= exp3.length() - 1; i++){
            System.out.print(exp3.charAt(i));
            Thread.sleep(50);
        }
    }

    public static String getStarted() throws InterruptedException {
        String text = "ARE YOU READY? (Type [Y] if YES, or [N] if NOT and press ENTER): ";
        String c;
        Scanner input = new Scanner(System.in);

        System.out.print("\n\n\t\t");
        for(int i = 0; i <= text.length() - 1; i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(50);
        }

        do{
            c = input.next();
            c = c.toUpperCase();
            if(c.length() == 1 && (c.charAt(0) == 'Y' || c.charAt(0) == 'N')){
                break;
            }
            System.out.print("\n\t\t");
            for(int i = 0; i <= text.length() - 1; i++) {
                System.out.print(text.charAt(i));
                Thread.sleep(50);
            }
        }while(true);

        return c;
    }

    static public String introduceWords() throws InterruptedException {
        String text = "-> INTRODUCE THE WORDS PULLING THEM AWAY WITH A SPACE BETWEEN THEM AND PRESS ENTER WHEN FINISHED.";
        String text2 = "--> Words: ";
        String text3 = "--> Are you sure that you want to use the words";
        String text4 = "--> (Type [Y] if YES, or [N] if NOT and press ENTER): ";
        String text5 = "-> INTRODUCE THE NEW WORDS.";
        String words;
        String response;

        Scanner input = new Scanner(System.in);

        System.out.print("\n\t\t");
        for(int i = 0; i <= text.length() - 1; i++) {
                System.out.print(text.charAt(i));
                Thread.sleep(50);
            }

        do{
            System.out.print("\n\t\t");
            for(int i = 0; i <= text2.length() - 1; i++) {
                System.out.print(text2.charAt(i));
                Thread.sleep(50);
            }

            words = input.nextLine();

            System.out.print("\n\t\t");
            for(int i = 0; i <= text3.length() - 1; i++) {
                System.out.print(text3.charAt(i));
                Thread.sleep(50);
            }
            System.out.print(" [" + words + "]" + "? ");
            System.out.print("\n\t\t");
            for(int i = 0; i <= text4.length() - 1; i++) {
                System.out.print(text4.charAt(i));
                Thread.sleep(50);
            }

            response = input.nextLine();
            response = response.toUpperCase();

            if(response.length() == 1 && response.charAt(0) == 'Y'){
                break;
            }

            System.out.print("\n\t\t");
            for(int i = 0; i <= text5.length() - 1; i++) {
                System.out.print(text5.charAt(i));
                Thread.sleep(50);
            }

        }while(true);


        return words;
    }

    public static int choosingPasswordLength() throws InterruptedException {
        String text = "-> NOW A LENGTH BETWEEN 8 AND 16 CHARACTERS IS GOING TO BE CHOSEN";
        String text2 = "--> Select one of both lengths (Type 8 or 16 and press ENTER): ";
        String text3 = "-> INCORRECT LENGTH INTRODUCED.";
        int response;

        Scanner input = new Scanner(System.in);

        System.out.print("\n\t\t");
        for(int i = 0; i <= text.length() - 1; i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(50);
        }

        do{
            System.out.print("\n\t\t");
            for(int i = 0; i <= text2.length() - 1; i++) {
                System.out.print(text2.charAt(i));
                Thread.sleep(50);
            }

            response = input.nextInt();

            if(response == 8 || response == 16){
                break;
            }

            System.out.print("\n\t\t");
            for(int i = 0; i <= text3.length() - 1; i++) {
                System.out.print(text3.charAt(i));
                Thread.sleep(50);
            }
        }while(true);

        return response;
    }

    public static void checkAndBuild(ArrayList<String> wordsForPasswordArray, int passwordLength) {
        if(passwordLength > wordsForPasswordArray.size()){
            while(true){
                if(passwordLength == wordsForPasswordArray.size()){
                    break;
                }
                wordsForPasswordArray.add(wordsForPasswordArray.get(0));
            }
        }
    }

    public static ArrayList<Character> getPassword(ArrayList<String> wordsForPasswordArray, int passwordLength) throws InterruptedException {
        ArrayList<Character> passwordArray = new ArrayList<>();
        int aux = 0;
        int totalAscii = 0;
        int wordAscii;
        int totalAsciiFinal = 0;
        int value;
        int k;
        String word;

        for(int i = 0; i < passwordLength; i++){
            totalAscii = 0;
            for(int j = i; j < wordsForPasswordArray.size(); j++){
                word = wordsForPasswordArray.get(j);
                wordAscii = 0;
                for(int z = 0; z < word.length(); z++){
                    wordAscii += Character.getNumericValue(word.charAt(z));
                }
                totalAscii += wordAscii;
            }
            totalAsciiFinal += totalAscii;
            value = totalAsciiFinal/(wordsForPasswordArray.get(i).length()+1);
            k = 0;
            boolean bool = true;
            while(bool) {
                if(value >= 33 && value <= 126){
                    bool = false;
                }
                if(value < 33){
                    k--;
                    value = totalAsciiFinal/(wordsForPasswordArray.get(i).length() + (k+i) * wordsForPasswordArray.get(i).length());
                }
                if(value > 126){
                    k++;
                    value = totalAsciiFinal/(wordsForPasswordArray.get(i).length() + (k+i) *wordsForPasswordArray.get(i).length());
                }


                //System.out.println("DATOS: \n" + "palabra: " + wordsForPasswordArray.get(i) + " i: " + i + " k: " + k + " value: " + value);
                Thread.sleep(100);
            }
            passwordArray.add((char) value);
        }
        return passwordArray;
    }
}