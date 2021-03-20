package geekbrains;
import java.util.Scanner;
import java.util.Random;


public class Lesson03 {
    String[] wordList={
            "apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
            "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Lesson03 obj=new Lesson03();
        String guessWord = obj.guessWord();
        String userWord;
        do {
            userWord=sc.next();
        } while(!obj.getAnswer(userWord, guessWord));
    }

    String guessWord(){
        Random ranGen = new Random();
        String guessWord=wordList[ranGen.nextInt(wordList.length-1)];
        //System.out.println("Guessed word is "+ guessWord);
        return guessWord;
    }


    boolean getAnswer(String userWord, String guessWord){
        if (guessWord.equals(userWord)) {
            System.out.println("You've guessed correctly! You won!");
            return true;
        } else {
            int floor = Math.min(guessWord.length(),userWord.length());
            for (int i=0; i<floor;i++){
                if (guessWord.charAt(i)==userWord.charAt(i)){
                    System.out.print(guessWord.charAt(i));
                } else {
                    System.out.print("#");
                }

            }
            for (int i=floor;i<15;i++){
                System.out.print("#");
            }
            System.out.println();
            return false;
        }
    }
}
