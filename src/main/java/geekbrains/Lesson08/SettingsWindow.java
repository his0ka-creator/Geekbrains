package geekbrains.Lesson08;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    //Задаем параметры окна по умолчанию
    private static final int WINDOW_WIDTH=350;
    private static final int WINDOW_HEIGHT=400;

    private static final int MIN_WIN_LENGTH=3;
    private static final int MAX_WIN_LENGTH=3;

    private static final int MIN_FIELD_SIZE=3;
    private static final int MAX_FIELD_SIZE=10;

    private static final String FIELD_SIZE_STRING="Field size: ";
    private static final String WIN_LENGTH_STRING = "Win length: ";

    private JRadioButton humanVsAI;
    private JRadioButton humanVsHuman;
    private ButtonGroup mode;


    private MainWindow gameWindow;
    private JSlider winLength;
    private JSlider fieldSize;

    private int setGameMode;
    private int setFieldSize;
    private int setWinLength;



    public SettingsWindow(MainWindow gameWindow){
        this.gameWindow=gameWindow;
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        //setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocation((MainWindow.DISPLAY_WIDTH-WINDOW_WIDTH)/2,(MainWindow.DISPLAY_HEIGHT-WINDOW_HEIGHT)/2);
        setLocationRelativeTo(gameWindow);
        setResizable(false);
        setTitle("Settings");
        setLayout(new GridLayout(10,1));

        addGameMode();

        addSliders();

        JButton button1 = new JButton("START");
        JButton button2 = new JButton("EXIT");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        add(buttonPanel);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSettings();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void saveSettings() {
        if (humanVsAI.isSelected()) setGameMode=0;
        else if (humanVsHuman.isSelected()) setGameMode=1;
        else {
            throw new RuntimeException("INVALID GAME TYPE!");
        }
        setFieldSize=fieldSize.getValue();
        setWinLength=winLength.getValue();
        setVisible(false);
        gameWindow.startGame(setGameMode, setFieldSize, setWinLength);

    }

    private void addSliders() {
        JLabel labelFieldSize = new JLabel(FIELD_SIZE_STRING+MIN_FIELD_SIZE);
        add(labelFieldSize);
        fieldSize=new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE,MIN_FIELD_SIZE);

        fieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int curFieldSize = fieldSize.getValue();
                labelFieldSize.setText(FIELD_SIZE_STRING+curFieldSize);
                winLength.setMaximum(curFieldSize);
            }
        });

        add(fieldSize);

        winLength=new JSlider(MIN_WIN_LENGTH, MAX_WIN_LENGTH, MIN_WIN_LENGTH);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_STRING+MIN_WIN_LENGTH);
        winLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int curWinLength = winLength.getValue();
                labelWinLength.setText(WIN_LENGTH_STRING+curWinLength);
            }
        });
        add(labelWinLength);
        add(winLength);
    }

    private void addGameMode() {
        humanVsAI = new JRadioButton("Human Versus AI",true);
        humanVsHuman = new JRadioButton("Versus Human");

        mode = new ButtonGroup();
        mode.add(humanVsAI);
        mode.add(humanVsHuman);

        //gameMode = new JPanel();
        //gameMode.setLayout(new GridLayout(4,1));
        add(new JLabel("Choose game mode: "));
        add(humanVsAI);
        add(humanVsHuman);
        //add(gameMode);
    }
}
