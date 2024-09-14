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

    public Greeting(int a, int b, String title, String[] nextPage, String[] currentPage) {
        super(a, b, title, nextPage, currentPage);
    }

    @Override
    public void config() {
        System.out.println("Config of title " + frame.getTitle());
        chechkButton.setBounds(80, 200, 95, 30);
        chechkButton.addActionListener(e -> {

            nextPage[0] = "Check";

            //JOptionPane.showMessageDialog(null, "Check button clicked");
        });
        signInButton.setBounds(200, 200, 95, 30);
        signInButton.addActionListener(e -> {
            //JOptionPane.showMessageDialog(null, "Sign In button clicked");
        });
        panel.add(label);
        frame.add(chechkButton);
        frame.add(signInButton);
        frame.add(panel);
        if (!curPage[0].equals("Greeting")) {
            System.out.println("Greeting page is not visible" + curPage);
            frame.setVisible(false);
        } else {
            frame.setVisible(true);
        }
    }

}
