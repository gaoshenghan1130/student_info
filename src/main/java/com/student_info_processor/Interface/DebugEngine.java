package com.student_info_processor.Interface;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DebugEngine extends Window {

    static String bugReport;

    public DebugEngine(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);
    }

    @Override
    public void config() {
        //System.out.println("Config of title " + frame.getTitle());
        if (nextPage.length >= 2 && nextPage[0].equals("DebugEngine")) {
            // System.out.println(nextPage[0] + nextPage[1]);
            bugReport = nextPage[1];
        } else {
            // System.out.println("No bug report");
            bugReport = "No bug report";
        }

        JPanel panel = new JPanel();
        JLabel label = new JLabel(bugReport);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            nextPage[0] = "Connection";
            nextPage[1] = "";
        });

        panel.add(label);
        panel.add(backButton);
        frame.add(panel);
        if (!curPage[0].equals("DebugEngine")) {
            // System.out.println("DebugEngine page is not visible");
            frame.setVisible(false);
        } else {
            frame.setVisible(true);
        }

    }

}
