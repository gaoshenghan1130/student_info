package com.student_info_processor.Interface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;

import java.sql.Statement;
import java.sql.ResultSet;

public class Check extends Window {

    public Check(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);

    }

    @Override
    public void config() {

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Check Page");
        JButton backButton = new JButton("Back");
        backButton.setBounds(80, 200, 95, 30);
        backButton.addActionListener(e -> {
            nextPage[0] = "Greeting";
        });

        panel.add(label);
        frame.add(backButton);
        frame.add(panel);

        // debugger
        // System.out.println("Config of title " + frame.getTitle());

        if (conn == null) {
            nextPage[0] = "DebugEngine";
            nextPage[1] = "No connection to database";
            System.out.println("No connection to database");
        }

        try {
            String query = "SELECT * FROM students";

            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);
            ResultSet rs = stmt.executeQuery(query);

            String[][] data = new String[100][100];
            String[] columns = new String[] { "id", "class_id", "name", "gender", "score" };

            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    data[rs.getRow()][i] = rs.getString(columns[i]);
                }

            }

            JTable table = new JTable(data, columns);
            panel.add(table);

            // close statement for memory
            if (stmt != null) {
                stmt.close();
            }

        } catch (Exception e) {
            nextPage[0] = "DebugEngine";
            nextPage[1] = e.toString();
        }

        // switcher
        if (!curPage[0].equals("Check")) {
            frame.setVisible(false);
        } else {
            frame.setVisible(true);
        }

    }

}
