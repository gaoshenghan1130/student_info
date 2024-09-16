# STUDENT INFO

## Instruction

- This is a simple java and SQL project that takes in student information and stores it with MYSQL database.

## How to run the project

- Clone the project to your local machine.
- Open the project in your favorite IDE.
- Navigate to "*/student_info" and type the following command in the terminal:

```bash
   make 
   make run
```

### For Windows users

- WSL is nessesary to run the project on Windows.
- Install WSL and follow the same steps as above in the WSL terminal.

## How to use the project

- The project is able to access the database provided, and you can insert or check student's information.

### Login for connection

- The database is not provided in the project, but you can use the following credentials to login to other databases.

- (For local database: user can leave the  `url` and `username` empty as they are already set in the code as `jdbc:mysql://localhost:3306/` and `root` respectively)

### Database

- This project is only compatible with MYSQL database. The name of the database should be set as `test` and the table name is `students`. The table should have the following columns: `class_id`, `name`, and `age` and `score`.

- The following is the SQL command to create the table:

```sql
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
      class_id VARCHAR(255),
      name VARCHAR(255),
      age INT,
      score INT
);
```

- Or you can run the file `mysql-init-test-data.sql` in the project to create the table.

### Functions

- The project has the following functions:

1. Insert student information
2. Check student information

(Currently the project only supports these two functions and might be updated in the future)
