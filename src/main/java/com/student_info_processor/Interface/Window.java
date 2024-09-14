package com.student_info_processor.Interface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Window {
    // fields
    private JFrame frame;

    // constructor

    public Window(String title) {
        System.out.println("Window of title " + title);
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public Window(int a, int b, String title) {
        System.out.println("Window of title " + title + "and size " + a + " x " + b);
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(a, b);
        frame.setVisible(true);
    }

    // methods

    public int windowOut() {
        System.out.println("WindowOut");
        return 0;
    }

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

}
