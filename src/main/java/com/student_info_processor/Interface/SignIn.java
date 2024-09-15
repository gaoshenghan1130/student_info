package com.student_info_processor.Interface;

import com.student_info_processor.SQL.SQL_Interface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class SignIn extends Window implements SQL_Interface {
    public SignIn(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);
    }

    @Override
    public void config() {
        System.out.println("Config of title " + frame.getTitle());

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // name input
        panel_name.add(label_name);
        panel_name.add(text_name);

        mainPanel.add(panel_name);

        // back button
        backButton.addActionListener(e -> {
            nextPage[0] = "Greeting";
        });
        backButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel_bottom.add(backButton);

        mainPanel.add(panel_bottom);

        frame.add(mainPanel, BorderLayout.CENTER);
    }

    JPanel mainPanel = new JPanel();

    JPanel panel_bottom = new JPanel();
    JButton backButton = new JButton("Back");

    JPanel panel_name = new JPanel();
    JLabel label_name = new JLabel("Input name here");
    JTextField text_name = new JTextField(20);

    @Override
    public void connect(String url, String user, String password) {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeConnection(Connection conn) {
        // TODO Auto-generated method stub

    }

    @Override
    public void insertData(Connection conn) {
        // TODO Auto-generated method stub
    }

}
