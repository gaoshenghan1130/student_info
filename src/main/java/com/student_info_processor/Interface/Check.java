package com.student_info_processor.Interface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Check extends Window {

    public Check(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);

    }

    @Override
    public void config() {

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Check Page");
        JButton backButton = new JButton("Back");
        backButton.setBounds(80, 200, 95, 30);
        backButton.addActionListener(e -> {
            nextPage[0] = "Greeting";
        });

        panel.add(label);
        frame.add(backButton);
        frame.add(panel);

        // debugger
        System.out.println("Config of title " + frame.getTitle());

        // switcher
        if (!curPage[0].equals("Check")) {
            frame.setVisible(false);
        } else {
            frame.setVisible(true);
        }
    }

}
