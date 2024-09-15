package com.student_info_processor.Interface;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;

public class Window {
    // fields
    public String[] curPage = {};
    public String[] nextPage = {};
    protected JFrame frame;
    protected Connection conn;

    // constructor

    public Window(int width, int height, String title, String[] nextPage, String[] currentPage) {
        System.out.println("Window of title " + title + "and size " + width + " x " + height);
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        this.nextPage = nextPage;
        this.curPage = currentPage;
    }

    // window concerned methods

    public void configWindow() {

        // first call the config method for the subclassess
        config();
        System.out.println("Config window of title " + frame.getTitle());
        // Set the default close operation to DO_NOTHING_ON_CLOSE
        // This prevents the window from closing automatically when the close button is
        // clicked
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Add a WindowListener to detect when the close button is clicked
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Handle the window close event here
                int response = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to close the window?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                // If the user confirms the close action, exit the application
                if (response == JOptionPane.YES_OPTION) {
                    nextPage[0] = "Closing";
                    // Exit the application
                }
            }
        });
    }

    public void config() {
        System.out.println("Config of title " + frame.getTitle());
    }

    public void windowClose() {
        System.out.println("WindowClose of title " + frame.getTitle());
        frame.dispose();
    }

    public Connection getConnection() {
        System.out.println("Connection of data base used");
        return conn;
    }

}
