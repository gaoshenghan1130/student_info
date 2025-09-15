package com.student_info_processor.Config;

public class Config {
    public static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/"; // Database URL
    public static final String DEFAULT_USER = "root";
    public static final String DEFAULT_DB = "pointSys";
    public static final String TABLE_NAME = "users";
    public static final String[] COLUMNS = { "unique_name", "name", "point"};
}
