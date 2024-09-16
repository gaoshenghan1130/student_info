package com.student_info_processor.Interface;

import com.student_info_processor.SQL.SQL_Interface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.sql.PreparedStatement;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class SignIn extends Window implements SQL_Interface {
    public SignIn(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);
    }

    @Override
    public void config() {
        // System.out.println("Config of title " + frame.getTitle());

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // class_id
        panel_class_id.add(label_class_id);
        panel_class_id.add(text_class_id);
        // name
        panel_name.add(label_name);
        panel_name.add(text_name);
        // gender
        panel_gender.add(label_gender);
        panel_gender.add(text_gender);
        // score
        panel_score.add(label_score);
        panel_score.add(text_score);

        mainPanel.add(panel_name);
        mainPanel.add(panel_class_id);
        mainPanel.add(panel_gender);
        mainPanel.add(panel_score);

        // insert button
        inserButton.addActionListener(e -> {
            String[] data = new String[4];
            data[0] = text_class_id.getText();
            data[1] = text_name.getText();
            data[2] = text_gender.getText();
            data[3] = text_score.getText();
            insertData(data);
            nextPage[0] = "Check";
        });
        panel_b.add(inserButton);

        // back button
        backButton.addActionListener(e -> {
            nextPage[0] = "Greeting";
        });
        backButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel_bottom.add(backButton);

        mainPanel.add(panel_b);
        mainPanel.add(panel_bottom);

        frame.add(mainPanel, BorderLayout.CENTER);
    }

    JPanel mainPanel = new JPanel();

    JPanel panel_b = new JPanel();
    JButton inserButton = new JButton("Insert");

    JPanel panel_bottom = new JPanel();
    JButton backButton = new JButton("Back");

    JPanel panel_class_id = new JPanel();
    JLabel label_class_id = new JLabel("class id:");
    JTextField text_class_id = new JTextField(20);
    JPanel panel_name = new JPanel();
    JLabel label_name = new JLabel("name:");
    JTextField text_name = new JTextField(20);
    JPanel panel_gender = new JPanel();
    JLabel label_gender = new JLabel("gender:");
    JTextField text_gender = new JTextField(20);
    JPanel panel_score = new JPanel();
    JLabel label_score = new JLabel("score:");
    JTextField text_score = new JTextField(20);

    @Override
    public void insertData(String[] data) {
        try {
            PreparedStatement stmt = conn
                    .prepareStatement("INSERT INTO students (class_id, name, gender, score) VALUES (?, ?, ?, ?)");
            for (int i = 0; i < data.length; i++) {
                stmt.setString(i + 1, data[i]);
            }

            // Check if the insertion was successful
            if (stmt.executeUpdate() > 0) {
                System.out.println("A new student was inserted successfully!");
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println("Error in inserting data, double check variable type");
        }

    }

}
