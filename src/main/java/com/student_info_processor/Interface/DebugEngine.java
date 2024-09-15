package com.student_info_processor.Interface;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DebugEngine extends Window {

    static String bugReport;

    public DebugEngine(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);
    }

    @Override
    public void config() {
        System.out.println("Config of title " + frame.getTitle());
        if (nextPage.length >= 2) {
            bugReport = nextPage[1];
        } else {
            bugReport = "No bug report";
        }

        JPanel panel = new JPanel();
        JLabel label = new JLabel(bugReport);
        panel.add(label);
        frame.add(panel);
        if (!curPage[0].equals("DebugEngine")) {
            System.out.println("DebugEngine page is not visible" + curPage);
            frame.setVisible(false);
        } else {
            frame.setVisible(true);
        }

    }

}
