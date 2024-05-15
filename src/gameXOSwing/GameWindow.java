package gameXOSwing;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_POS_X = 500;
    static final int WINDOW_POS_Y = 300;
    static final int WINDOW_WIDTH = 500;
    static final int WINDOW_HEIGTH = 555;

    private WindowSettings settingsWindow;
    private BattleField battleField;


    public GameWindow() {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");

        settingsWindow = new WindowSettings(this);
        battleField = new BattleField(this);
        add(battleField, BorderLayout.CENTER);


        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton btnNewGame = new JButton("Play");
        JButton btnExit = new JButton("Exit");
        panel.add(btnNewGame);
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);
        btnExit.setBackground(Color.PINK);
        btnNewGame.setBackground(Color.CYAN);

        btnExit.addActionListener(e -> System.exit(0));

        btnNewGame.addActionListener(e -> settingsWindow.setVisible(true));


        setVisible(true);
    }

    void startNewGame(int size, int winline) {
        battleField.startNewGame(size, winline);
    }
}