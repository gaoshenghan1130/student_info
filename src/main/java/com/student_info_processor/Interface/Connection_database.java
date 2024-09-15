package com.student_info_processor.Interface;

import java.sql.Connection;

public class Connection_database extends Window {
    
        public Connection_database(int width, int height, String title, String[] nextPage, String[] currentPage) {
            super(width, height, title, nextPage, currentPage);
        }

        Connection conn = super.conn;
    
        @Override
        public void config() {
            // TODO Auto-generated method stub
    
        }
    
}
