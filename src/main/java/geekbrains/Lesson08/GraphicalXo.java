package geekbrains.Lesson08;

import javax.swing.*;

public class GraphicalXo {
    public static void main(String[] args){
        new MainWindow();
    }

    static class MainWindow extends JFrame {
        MainWindow(){
            setSize(800,600);
            setVisible(true);
        }
    }
}
