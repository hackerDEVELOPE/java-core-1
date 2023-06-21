package window;

import javax.swing.*;
import java.awt.*;

public class WindowTest extends JFrame {
    public WindowTest() {
        setBounds(200, 200, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Window");

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        add(panel);

        JTextField textField = new JTextField();
        add(textField, BorderLayout.NORTH);
        JTextField textField2 = new JTextField();
        add(textField2, BorderLayout.SOUTH);

        setVisible(true);
    }
}
