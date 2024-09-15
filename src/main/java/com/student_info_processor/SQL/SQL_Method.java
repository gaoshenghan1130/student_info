package com.student_info_processor.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL_Method {
    public Connection connect(String url, String user, String password) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
