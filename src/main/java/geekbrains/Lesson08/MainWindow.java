package geekbrains.Lesson08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainWindow extends JFrame {
        //Задаем размеры окна по умолчанию
        private static final int WINDOW_WIDTH=800;
        private static final int WINDOW_HEIGHT=600;

        //Узнаем разрешение экрана для простоты позиционирования окна по центру
        protected static final GraphicsDevice GD = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        protected static final int DISPLAY_WIDTH=GD.getDisplayMode().getWidth();
        protected static final int DISPLAY_HEIGHT=GD.getDisplayMode().getHeight();

        protected GameMap map;



        MainWindow(){
            setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation((DISPLAY_WIDTH-WINDOW_WIDTH)/2,(DISPLAY_HEIGHT-WINDOW_HEIGHT)/2);
            setTitle("Tic Tac Toe");
            setResizable(false);

            setLayout(new BorderLayout());
            JButton button1=new JButton("SETTINGS");
            JButton button2=new JButton("EXIT");
            JPanel panel = new JPanel();
            panel.add(button1);
            panel.add(button2);
            panel.setLayout(new GridLayout(1,2));
            add(panel,BorderLayout.SOUTH);

            SettingsWindow settings = new SettingsWindow(this);
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    settings.setVisible(true);
                    }
            });



        }



    public void startGame(int setGameMode, int setFieldSize, int setWinLength) {
        map = new GameMap();
        map.startGame(setGameMode,setFieldSize,setWinLength);

        }
}
