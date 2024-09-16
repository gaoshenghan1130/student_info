package com.student_info_processor.Interface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTable;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Check extends Window {

    public Check(int width, int height, String title, String[] nextPage, String[] currentPage) {
        super(width, height, title, nextPage, currentPage);

    }

    @Override
    public void config() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Check Page");

        JButton backButton = new JButton("Back");
        backButton.setBounds(80, 200, 95, 30);
        backButton.addActionListener(e -> {
            nextPage[0] = "Greeting";
        });

        panel.add(label);
        panel.add(backButton);
        frame.add(panel);

        // debugger
        // System.out.println("Config of title " + frame.getTitle());

        if (conn == null) {
            nextPage[0] = "DebugEngine";
            nextPage[1] = "Lose connection to database";
            // System.out.println("No connection to database");
        }

        try {
            String query = "SELECT * FROM students";

            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);
            ResultSet rs = stmt.executeQuery(query);

            List<String[]> data = new ArrayList<>();// ensure that the data storage is dynamic (can store any number of
                                                    // rows)
            String[] columns = new String[] { "id", "class_id", "name", "gender", "score" };

            while (rs.next()) {
                String[] row = new String[5]; // Since there are 5 columns
                for (int i = 0; i < columns.length; i++) {
                    row[i] = rs.getString(columns[i]);
                }
                data.add(row);
            }
            String[][] dataArray = data.toArray(new String[0][]);

            JTable table = new JTable(dataArray, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane);

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
