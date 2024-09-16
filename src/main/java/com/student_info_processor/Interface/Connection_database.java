package com.student_info_processor.Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

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
        JPasswordField password = new JPasswordField(20);
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
            try {

                String nurl;
                if (url.getText().equals("")) {
                    nurl = "jdbc:mysql://localhost:3306/test";
                } else {
                    nurl = user.getText();
                }

                String nuser;
                if (user.getText().equals("")) {
                    nuser = "root";
                } else {
                    nuser = user.getText();
                }

                Connection nconn = DriverManager.getConnection(nurl, nuser, password.getText());
                this.conn = nconn;
                System.out.println("Connection established");
                nextPage[0] = "Greeting";
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("Connection failed");
                nextPage[0] = "DebugEngine";
                nextPage[1] = "Connection failed";
                // e1.printStackTrace();
            }

        });

        panel.add(Confirm);

        frame.setLayout(new FlowLayout());
        frame.add(panel);
    }

}
