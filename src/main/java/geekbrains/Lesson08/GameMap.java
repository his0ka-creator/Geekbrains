package geekbrains.Lesson08;

import javax.swing.*;

public class GameMap extends JPanel {
    public void startGame(int setGameMode, int setFieldSize, int setWinLength) {
        System.out.printf("New game on %dx%d field, Win length is %d, game mode is %d started\n",setFieldSize,setFieldSize,setWinLength,setGameMode);
    }
}
