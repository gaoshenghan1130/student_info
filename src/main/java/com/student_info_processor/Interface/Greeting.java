package com.student_info_processor.Interface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Greeting extends Window {

    JPanel panel = new JPanel();
    JLabel label = new JLabel("Welcome to Student Info Processor");
    JButton chechkButton = new JButton("Check");
    JButton signInButton = new JButton("Sign In");

    public Greeting(int a, int b, String title) {
        super(a, b, title);
    }

    public void config() {
        chechkButton.setBounds(80, 200, 95, 30);
        chechkButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Check button clicked");
        });
        signInButton.setBounds(200, 200, 95, 30);
        signInButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Sign In button clicked");
        });
        panel.add(label);
        frame.add(chechkButton);
        frame.add(signInButton);
        frame.add(panel);
    }

}
