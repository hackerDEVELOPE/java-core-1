package window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        setBounds(200, 200, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Window");

        setLayout(new BorderLayout());

        JButton button = new JButton("Button 1");
        add(button, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();

        JButton button2 = new JButton("Button 2");
        southPanel.add(button2, BorderLayout.SOUTH);
        JButton button3 = new JButton("Button 3");
        southPanel.add(button3, BorderLayout.SOUTH);
        JButton button4 = new JButton("Button 4");
        southPanel.add(button4, BorderLayout.SOUTH);

        southPanel.setLayout(new GridLayout(1, 2));
        add(southPanel, BorderLayout.SOUTH);

        JTextArea textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);
        button.addActionListener(e -> textArea.append("hello \n"));

        button2.addActionListener(e -> textArea.append("world\n"));

        setVisible(true);
    }
}
