package com.student_info_processor.Interface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class SignIn extends Window {
    public SignIn(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);
    }

    @Override
    public void config() {
        System.out.println("Config of title " + frame.getTitle());

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        // name input
        text_name.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                System.out.println("Name: " + text_name.getText());
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                System.out.println("Name: " + text_name.getText());
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                System.out.println("Name: " + text_name.getText());
            }

        });
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

}
