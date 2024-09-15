package com.student_info_processor.SQL;

import java.sql.Connection;

public interface SQL_Interface {
    public void connect(String url, String user, String password);

    public void closeConnection(Connection conn);

    public void insertData(Connection conn);
};
