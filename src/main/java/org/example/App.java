package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class App extends JFrame {

    App() {
        super("Bingo");
        setBounds(300,50,800,600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new GridLayout(6,5));
        getContentPane().add(new JLabel("B", SwingConstants.CENTER));
        getContentPane().add(new JLabel("I", SwingConstants.CENTER));
        getContentPane().add(new JLabel("N", SwingConstants.CENTER));
        getContentPane().add(new JLabel("G", SwingConstants.CENTER));
        getContentPane().add(new JLabel("O", SwingConstants.CENTER));

        createButtons();

        setVisible(true);
    }

    void createButtons() {
        JButton[][] buttons = new JButton[5][5];
        Random random = new Random();
        TreeSet<Integer> numbers = new TreeSet<>();
        while (numbers.size() < 25) {
            numbers.add(random.nextInt(75)+1);
        }
        for (int r = 0; r < 5; r++)
            for (int c = 0; c < 5; c++) {
                buttons[r][c] = new JButton("" + numbers.pollFirst() );
                getContentPane().add(buttons[r][c]);
                int r1 = r, c1 = c;
                buttons[r][c].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttons[r1][c1].setBackground(Color.RED);
//                        buttons[r1][c1].setBorderPainted(false);
                        buttons[r1][c1].setOpaque(true);
                    }
                });
            }
    }

    public static void main(String[] args) {
        new App();
    }
}
