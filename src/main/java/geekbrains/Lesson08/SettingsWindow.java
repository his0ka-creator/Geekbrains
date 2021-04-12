package geekbrains.Lesson08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    //Задаем параметры окна по умолчанию
    private static final int WINDOW_WIDTH=700;
    private static final int WINDOW_HEIGHT=500;

    //Узнаем разрешение экрана для простоты позиционирования окна по центру
    private static final GraphicsDevice GD = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static final int DISPLAY_WIDTH=GD.getDisplayMode().getWidth();
    private static final int DISPLAY_HEIGHT=GD.getDisplayMode().getHeight();

    //позиция окна
    private static final int WIN_POS_X=(DISPLAY_WIDTH-WINDOW_WIDTH)/2;
    private static final int WIN_POS_Y=(DISPLAY_HEIGHT-WINDOW_HEIGHT)/2;

    public SettingsWindow(){
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocation((MainWindow.DISPLAY_WIDTH-WINDOW_WIDTH)/2,(MainWindow.DISPLAY_HEIGHT-WINDOW_HEIGHT)/2);
        setLocationRelativeTo(null);
        setTitle("Settings");

        JRadioButton versusAI = new JRadioButton("Versus AI");
        JRadioButton versusHuman = new JRadioButton("Versus Human");

        ButtonGroup mode = new ButtonGroup();
        mode.add(versusAI);
        mode.add(versusHuman);

        JPanel gameMode = new JPanel();
        gameMode.add(versusAI);
        gameMode.add(versusHuman);
        add(gameMode, BorderLayout.NORTH);






        JButton button1 = new JButton("EXIT");
        add(button1,BorderLayout.SOUTH);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
