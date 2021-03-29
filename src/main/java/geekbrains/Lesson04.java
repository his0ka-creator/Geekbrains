package geekbrains;

import java.util.Scanner;
import java.util.Random;

//TicTacToe
public class Lesson04 {
    static final int FIELD_SIZE_X = 5;
    static final int FIELD_SIZE_Y = 5;
    static int counter = 4;
    char[][] field = new char[FIELD_SIZE_Y][FIELD_SIZE_X];
    static final char HUMAN_CHAR = 'X';
    static final char AI_CHAR = '0';
    static final char DEFAULT_CHAR = '*';
    static final Scanner SCANNER = new Scanner(System.in);
    static final Random RANDOM_GEN = new Random();

    public static void main(String[] args) {
        Lesson04 object = new Lesson04();
        while (true) {
           object.initArray(object.field);
           object.printField(object.field);
           while (true) {
                object.HumanMove();
                object.printField(object.field);
                System.out.println("Check victory");
                if (object.checkWinforN(counter, object.field, HUMAN_CHAR)) {System.out.println("You did Great! You won!!!");break;}
                System.out.println("Check empty spots");
                if (!isThereEmptySpot(object.field)) break;
                System.out.println("AI move");
                object.aiMoveForNImproved(counter, object.field);
                object.printField(object.field);
                if (object.checkWinforN(counter, object.field, AI_CHAR)) System.out.println("Sorry, pal! AI won!");
                if (!isThereEmptySpot(object.field)) break;
            }
            object.printField(object.field);
            System.out.println("Want to try again? :-) ");
            String again = SCANNER.next();
            if (!(again.equals("y"))) {break;}
        }

    }

    private static boolean isThereEmptySpot(char[][] field) {
        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            for (int j = 0; j < FIELD_SIZE_X; j++) {
                if (field[i][j] == DEFAULT_CHAR) {
                    //System.out.println("There is no empty spot");
                    return true;
                }
            }
        }
        return false;
    }

    private void AIMove() {
        while (true){
            int x=RANDOM_GEN.nextInt(FIELD_SIZE_X);
            int y=RANDOM_GEN.nextInt(FIELD_SIZE_Y);
            if (field[x][y]==DEFAULT_CHAR){field[x][y]='0'; break;}
        }

    }

    private void HumanMove() {
        while (true) {
            System.out.println("Ваш ход: ");
            int x = SCANNER.nextInt() - 1;
            int y = SCANNER.nextInt() - 1;
            if (!(x >= 0 && x < FIELD_SIZE_X && y >= 0 && y < FIELD_SIZE_Y)) continue;
            this.field[x][y] = HUMAN_CHAR;
            return;
        }
    }


    void initArray(char[][] field) {
        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            for (int j = 0; j < FIELD_SIZE_X; j++) {
                field[i][j] = DEFAULT_CHAR;
            }
        }
    }

    void printField(char[][] field) {
        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            for (int j = 0; j < FIELD_SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
        return;
    }

    boolean checkWin(char DOT, char[][] field) {
        //проверяем строки
        //System.out.println("Проверка строк");
        boolean winFlag;
        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            winFlag = true;
            for (int j = 0; j < FIELD_SIZE_X; j++) {
                if (!(DOT == field[i][j])) {
                    winFlag = false;
                    break;
                }
            }
            if (winFlag) return true;
        }
        //проверяю столбцы
        //System.out.println("Проверяем столбцы");
        for (int i = 0; i < FIELD_SIZE_X; i++) {
            winFlag = true;
            for (int j = 0; j < FIELD_SIZE_Y; j++) {
                if (!(DOT == field[j][i])) {
                    winFlag = false;
                    break;
                }
            }
            if (winFlag) return true;
        }

        //проверяю диагонали
        //System.out.println("Проверяю первую диагональ");
        winFlag = true;
        for (int i = 0; i < FIELD_SIZE_X; i++) {
            if (!(field[i][i] == DOT)) {
                winFlag = false;
                break;
            }
        }
        if (winFlag) return true;

        //вторая диагональ
        //System.out.println("проверяю вторую диагональ");
        winFlag=true;
        for (int i = FIELD_SIZE_X - 1; i >= 0; i--) {
            if (!(field[i][i] == DOT)) {
                winFlag = false;
                break;
            }
        }
        return winFlag;
    }

    boolean checkWinforN (int counter, char[][] field, char someonesDot){
        //System.out.println("check strings");
        int innerCounter=counter;
        for (int i = 0; i <FIELD_SIZE_Y ; i++) {
            for (int j=0; j < FIELD_SIZE_X; j++){
                if (someonesDot == field[i][j]){innerCounter--;}
                if (someonesDot != field[i][j]){innerCounter=counter;}
                if (innerCounter == 0) return true;
            }
            innerCounter=counter;
        }

        //System.out.println("check columns");
        innerCounter=counter;
        for (int i = 0; i < FIELD_SIZE_X; i++) {
            for (int j = 0; j < FIELD_SIZE_Y; j++) {
                if (someonesDot == field[j][i]){innerCounter--;}
                if (someonesDot != field[j][i]){innerCounter=counter;}
                if (innerCounter == 0) return true;
            }
            innerCounter=counter;
        }
        
        innerCounter=counter;
        //System.out.println("проверяем диагонали справа-налево (/) при i=0; j = [counter-1;FIELD_SIZE_Y-1]");

        for (int j = counter-1; j < FIELD_SIZE_Y; j++) {
            int i=0;
            int k=j;
            //диагональ справа-налево
            while (i<FIELD_SIZE_X && k<FIELD_SIZE_Y && i>=0 && k>=0){
                if (someonesDot == field[i][k]){innerCounter--;}
                if (someonesDot != field[i][k]){innerCounter=counter;}
                if (innerCounter == 0) return true;
                i++;
                k--;
            }
            i=innerCounter;
        }
        //System.out.println("проверяем диагонали (/) при i=FIELD_SIZE_X-1; j= [1; FIELD_SIZE_Y-1-counter]");

        for (int j = 1; j < FIELD_SIZE_Y-counter+1; j++) {
            //диагональ справа налево;
            int i=FIELD_SIZE_X-1;
            int k=j;
           // System.out.println(i+k);
            innerCounter=counter;
            while (i<FIELD_SIZE_X && k<FIELD_SIZE_Y && i>=0 && k>=0){
                if (someonesDot == field[i][k]){innerCounter--;}
                if (someonesDot != field[i][k]){innerCounter=counter;}
                if (innerCounter == 0) return true;
                i--;
                k++;
             //   System.out.println(i+k);
            }
        }

        //System.out.println("проверяем диагональ \\ при j=0; i=[0; FIELDSIZE-1-counter]");

        innerCounter=counter;
        for (int i = 0; i < FIELD_SIZE_X-counter+1; i++) {
            int j=0;
            int k=i;
            while (k < FIELD_SIZE_X && j < FIELD_SIZE_Y && k>=0 && j>=0){
                if (someonesDot == field[k][j]){innerCounter--;}
                if (someonesDot != field[k][j]){innerCounter=counter;}
                if (innerCounter == 0) return true;
                k++;
                j++;
            }
            innerCounter=counter;
        }
        //System.out.println("проверяем диагональ \\ при i=0; j=[1; FIELD_SIZE_Y-1-counter]");
        innerCounter=counter;
        for (int j = 1; j < FIELD_SIZE_Y-counter+1; j++) {
            int i=0;
            int k=j;
            innerCounter=counter;
            //System.out.println("Is there anybody out there?");
            while (i < FIELD_SIZE_X && k < FIELD_SIZE_Y && i>=0 && k>=0){
                if (someonesDot == field[i][k]){innerCounter--;}
                if (someonesDot != field[i][k]){innerCounter=counter;}
                if (innerCounter == 0) return true;
                //System.out.println("hello");
                i++;
                k++;
            }

        }

        return false;
    };

    void copyArray(char[][] a1, char[][] a2){
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[i].length; j++) {
                a2[i][j]=a1[1][j];
            }
        }
    }
    // данный алгоритм будет использовать checkWinforN для опеределения выигрышного хода и блокировать его
    // для начала буду использовать одинарную вложенность
    void aiMoveForNImproved(int counter, char[][] field){
        //вспомогательная копия массива

        for (int i = 0; i < FIELD_SIZE_Y; i++) {
            for (int j = 0; j < FIELD_SIZE_X;j++) {
                //copyArray(field,fieldModel);
                if (field[i][j]==DEFAULT_CHAR){
                    field[i][j]=HUMAN_CHAR;
                    if (checkWinforN(counter, field, HUMAN_CHAR)) {field[i][j]=AI_CHAR; return;}
                    else {
                       field[i][j]=DEFAULT_CHAR;
                    }
                }
            }

        }

        AIMove();
    }
}



