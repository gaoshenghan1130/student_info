# STUDENT INFO

## Notes

- This project is currently intended for backend storage of points of students for ieee umich student branch.

## Instruction

- This is a simple java and SQL project that takes in student information and stores it with MYSQL database.

## How to run the project

- Requirements:
  - JDK 8 or above
  - MySQL Server
  - Make sure to have `make` installed on your system. For Windows users, you can install it via [GnuWin](http://gnuwin32.sourceforge.net/packages/make.htm) or use a package manager like [Chocolatey](https://chocolatey.org/install); or just use a WSL terminal.

- Clone the project to your local machine.
- Open the project in your favorite IDE.
- Navigate to "*/student_info" and type the following command in the terminal(or execute `run.sh` in the project root):

```bash
   make 
   make run
```

## How to use the project

- The project is able to access the database provided, and you can insert or check student's information.

### Login for connection

- The database is not provided in the project, but you can use the following credentials to login to other databases.

- (For local database: user can leave the  `url` and `username` empty as they are already set in the code as `jdbc:mysql://localhost:3306/` and `root` respectively)

### Database

- This project is only compatible with MYSQL database. The name of the database should be set as `test` and the table name is `students`. The table should have the following columns: `unique_name`, `name`, `point`. But you can change the database name and table name in the `./src/main/java/com/student_info_processor/Config/Config.java` file.

### Functions

- The project has the following functions:

1. Insert student information
2. Check student information

(Currently the project only supports these two functions and might be updated in the future)
