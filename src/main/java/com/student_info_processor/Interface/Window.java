package com.student_info_processor.Interface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window {
    // fields
    protected JFrame frame;

    // constructor

    public Window(int width, int height, String title) {
        System.out.println("Window of title " + title + "and size " + width + " x " + height);
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    // window concerned methods

    public void windowClose() {
        System.out.println("WindowClose of title " + frame.getTitle());
        frame.dispose();
    }

    public void window_invisble() {
        System.out.println("WindowInvisible of title " + frame.getTitle());
        frame.setVisible(false);
    }

    public void window_visible() {
        System.out.println("WindowVisible of title " + frame.getTitle());
        frame.setVisible(true);
    }

    // buttons issue

    public void add_button(String button_name) {
        JButton button = new JButton(button_name);
        frame.add(button);
    }

}

