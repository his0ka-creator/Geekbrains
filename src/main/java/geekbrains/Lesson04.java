package geekbrains;

import java.util.Scanner;
import java.util.Random;

//TicTacToe
public class Lesson04 {
    static final int FIELD_SIZE_X=3;
    static final int FIELD_SIZE_Y=3;
    char[][] field = new char[FIELD_SIZE_Y][FIELD_SIZE_X];
    static final char HUMAN_CHAR='X';
    static final char AI_CHAR='0';
    static final char DEFAULT_CHAR='*';
    final Scanner SCANNER = new Scanner(System.in);
    final Random RANDOM_GEN = new Random();

    public static void main (String[] args){
        Lesson04 object = new Lesson04();
        object.initArray(object.field);
        object.printField(object.field);
        object.HumanMove();
        object.printField(object.field);
        object.AIMove();
    }

    private void AIMove() {
        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            for (int j = 0; j < FIELD_SIZE_X; j++) {
                if (this.field[i][j] == '*') { this.field[i][j] = AI_CHAR; break;}
            }
        }
        System.out.println("I'm outta moves...");
    }

    private void HumanMove() {
        System.out.println("Ваш ход: ");
        int x = SCANNER.nextInt()-1;
        int y = SCANNER.nextInt()-1;
        this.field[x][y]=HUMAN_CHAR;
    }


    void initArray(char[][] field){
        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            for (int j = 0; j < FIELD_SIZE_X; j++) {
                field[i][j]='*';
            }
        }
    }
    void printField(char[][] field){
        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            for (int j = 0; j < FIELD_SIZE_X; j++) {
                System.out.print(field[i][j]+"|");
                }
                System.out.println();
            }
    }

}

