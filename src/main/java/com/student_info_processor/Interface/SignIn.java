package com.student_info_processor.Interface;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignIn extends Window {
    public SignIn(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);
    }

    @Override
    public void config() {
        System.out.println("Config of title " + frame.getTitle());
        JPanel panel = new JPanel();
        JLabel label = new JLabel("SignIn Page");

        panel.add(label);
        frame.add(panel);

    }

}
