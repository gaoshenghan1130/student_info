CREATE DATABASE IF NOT EXISTS pointSys;

USE pointSys;

CREATE TABLE IF NOT EXISTS users (
    unique_name VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100),
    point INT
);