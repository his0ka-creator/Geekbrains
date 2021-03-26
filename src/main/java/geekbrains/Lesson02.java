package geekbrains;

import java.util.Random;

public class Lesson02 {
    public static void main(String[] args){
        Lesson02 a = new Lesson02();

        int[] tmpArr = a.task02();
        int[][] tmpArr2;

        //task 1
        System.out.println("Task01");
        tmpArr=a.task01();
        a.printArr(tmpArr);

        //task 2
        System.out.println("\nTask02");
        tmpArr=a.task02();
        a.printArr(tmpArr);

        //task 3
        System.out.println("\nTask03");
        tmpArr=a.task03();
        a.printArr(tmpArr);

        //task 4
        System.out.println("\nTask04");
        tmpArr2=a.task04(10);
        a.printArr(tmpArr2);

        //task 5
        System.out.printf("\n Task 05\n");
        a.task05(15);

        //task 6
        System.out.printf("\n Task 06\n");
        System.out.println(a.task06(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));//true
        //task 7

        System.out.printf("\n Task 07\n");
        tmpArr=a.task07(new int[]{7, 5, 11}, -1);
        a.printArr(tmpArr);
        System.out.println();
        tmpArr=a.task07(new int[]{12, 8, 34, -1}, 2);
        a.printArr(tmpArr);
    }
//1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, //0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    int[] task01() {
        int[] arr = {0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ 1;
        }
        return arr;
    }

    /*
    2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    */

    int[] task02() {
        int[] arr=new int[8];
        for (int i=0; i<arr.length; i++){
            arr[i]=3*i;
        }
        return arr;
    }
    /*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    */
    int[] task03() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        return arr;
    }
    /*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    */
    int[][] task04(int n) {
        int[][] arr = new int[n][n];
        //заполним массив нулями
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                arr[i][j]=0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][n - i - 1] = 1;
        }
        return arr;
    }
    /*
    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    */

    void task05(int n1){
        // инициализация массива случайными числами
        int[] arr=new int[n1];
        Random ranGen = new Random();
        for (int i=0; i<arr.length; i++){
            arr[i]=ranGen.nextInt(100);
        }

        //ищем минимальное и максимальное
        int min=arr[0];
        int max=arr[0];
        // System.out.print(arr[0]+" ; ");

        for (int i=1; i<arr.length; i++){
            if (arr[i]<min) min=arr[i];
            if (arr[i]>max) max=arr[i];
            System.out.print(arr[i]+" ");
        }

        //Вывод
        System.out.println("\nmin = "+min+"; max = "+max);

    }
    /*
    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    */

    boolean task06(int[] arr){
        int bSum=0;
        int eSum=0;
        //инициализируем eSum;
        for (int i=0; i<arr.length; i++){
            eSum+=arr[i];
        }
        for (int i=0; i<arr.length; i++){
            bSum+=arr[i];
            eSum-=arr[i];
            if (bSum == eSum) return true;
        }
        return false;
    }
    /*
    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    */
    int[] task07(int[] arr, int n){
        if (n==0) return arr;
        int tmp;
        if (n>0){
            for (int i=0; i<n; i++){
                for (int j=arr.length-1; j>0;j--){
                    tmp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        else {
            for (int i=n; i<0; i++){
                for (int j=1; j<arr.length; j++){
                    tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                }
            }

        }
        return arr;
    }


    //Вспомогательные функции вывода
    void printArr(int[] arr){
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
    }
    void printArr(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d  ", anInt);
            }
            System.out.println();
        }
    }
}
/*



/*





Если выполнение задач вызывает трудности, можете обратиться к последней странице методического пособия. Для задач со * не нужно искать решение в интернете, иначе вы теряете весь смысл их выполнения.
*/



