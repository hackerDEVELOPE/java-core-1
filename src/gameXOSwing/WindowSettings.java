package gameXOSwing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class WindowSettings extends JFrame {

    static final int WINDOW_POS_X = GameWindow.WINDOW_POS_X +50;
    static final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y + 50;
    static final int WINDOW_WIDTH = 400;
    static final int WINDOW_HEIGTH = 300;


    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private GameWindow gameWindow;
    private JSlider slFieldSize;
    private JSlider slWinLineLength;
    private   JButton btnNewGame;
    public WindowSettings(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGTH);
        setTitle("Tic Tac Toe settings");

        setLayout(new GridLayout(5,1));

        add(new Label("Field size:"));
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintLabels(true);
        slFieldSize.setPaintTicks(true);
        add(slFieldSize);

        add(new Label("Win line length:"));
        slWinLineLength = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slWinLineLength.setMajorTickSpacing(1);
        slWinLineLength.setPaintLabels(true);
        slWinLineLength.setPaintTicks(true);
        add(slWinLineLength);

        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                slWinLineLength.setMaximum(slFieldSize.getValue());
            }
        });

        btnNewGame = new JButton("Start new Game");
        add(btnNewGame);

        btnNewGame.addActionListener(e -> {
            int size = slFieldSize.getValue();
            int winline = slWinLineLength.getValue();

            Logic.SIZE = size;
            Logic.DOTS_TO_WIN = winline;
            Logic.initMap();
            Logic.gameFinished = false;

            gameWindow.startNewGame(size, winline);
            setVisible(false);

        });

        setVisible(false);
    }
}
