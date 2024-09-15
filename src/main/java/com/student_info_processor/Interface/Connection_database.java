package com.student_info_processor.Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connection_database extends Window {

    public Connection_database(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);
    }

    @Override
    public void config() {

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel topic = new JLabel("Connection to Database:");
        JLabel topic2 = new JLabel("Please input the following information:");

        JTextField url = new JTextField(20);
        url.setPreferredSize(new Dimension(url.getWidth(), 30));
        JTextField user = new JTextField(20);
        user.setPreferredSize(new Dimension(user.getWidth(), 30));
        JTextField password = new JTextField(20);
        password.setPreferredSize(new Dimension(password.getWidth(), 30));

        JLabel url_label = new JLabel("URL");
        JLabel user_label = new JLabel("User");
        JLabel password_label = new JLabel("Password");

        panel.add(topic);
        panel.add(topic2);

        panel.add(url_label);
        panel.add(url);

        panel.add(user_label);
        panel.add(user);

        panel.add(password_label);
        panel.add(password);

        JButton Confirm = new JButton("Confirm");

        Confirm.addActionListener(e -> {
            nextPage[0] = "Greeting";
        });

        panel.add(Confirm);

        frame.setLayout(new FlowLayout());
        frame.add(panel);
    }

}
