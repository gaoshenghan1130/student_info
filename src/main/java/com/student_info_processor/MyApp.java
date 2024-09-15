package com.student_info_processor;

import java.sql.Connection;

import javax.swing.*;
import com.student_info_processor.Interface.Check;
import com.student_info_processor.Interface.Connection_database;
import com.student_info_processor.Interface.Greeting;
import com.student_info_processor.Interface.Window;
import com.student_info_processor.Interface.SignIn;
import com.student_info_processor.Interface.DebugEngine;

import com.student_info_processor.SQL.SQL_Method;

public class MyApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Create initial page and window
            String[] currentPage = { "Connection" };// used to track the current page
            String[] nextPage = { "Connection" };// used to change the page inside each window, the second element is
                                                 // used
                                                 // to pass data between windows(E.g. bug report)
            Connection[] conn = { null };

            Window mainWindow = new Connection_database(400, 400, "Connection to database", nextPage, currentPage);
            mainWindow.configWindow();

            // Create a ReferenceWindow instance
            ReferenceWindow referenceWindow = new ReferenceWindow(mainWindow);

            // Handle page switching
            new Thread(() -> handlePageSwitch(referenceWindow, currentPage, nextPage, conn)).start();

            mainWindow = referenceWindow.window;

        });
    }

    private static Timer timer;

    private static void handlePageSwitch(ReferenceWindow referenceWindow, String[] currentPage, String[] nextPage,
            Connection[] conn) {
        // This method could be triggered by events or other mechanisms
        // Example page switch logic
        {

            timer = new Timer(500, e -> {
                if (currentPage[0].equals("Connection") && (!nextPage[0].equals("Connection"))) {
                    conn[0] = referenceWindow.getWindow().getConnection();
                    referenceWindow
                            .updateWindow(
                                    new Connection_database(400, 400, "Connection", nextPage, currentPage));
                }
                if (!currentPage[0].equals(nextPage[0])) {
                    switch (nextPage[0]) {
                        case "Connection":
                            currentPage[0] = "Connection";
                            referenceWindow.updateWindow(
                                    new Connection_database(400, 400, "Student Info Processor", nextPage, currentPage));
                            break;
                        case "Greeting":
                            currentPage[0] = "Greeting";
                            referenceWindow.updateWindow(
                                    new Greeting(400, 400, "Student Info Processor", nextPage, currentPage));
                            break;

                        case "Check":
                            currentPage[0] = "Check";
                            referenceWindow.updateWindow(new Check(400, 400, "Check", nextPage, currentPage));
                            break;

                        case "SignIn":
                            currentPage[0] = "SignIn";
                            referenceWindow.updateWindow(new SignIn(400, 400, "Sign In", nextPage, currentPage););
                            break;

                        case "DebugEngine":
                            currentPage[0] = "DebugEngine";
                            referenceWindow.updateWindow(new DebugEngine(400, 400, "Bug report", nextPage, currentPage));
                            break;

                        case "Closing":
                            System.exit(0);
                            break;

                        default:
                            break;
                    }
                }
                // System.out.println("Current page: " + currentPage[0]);
            });
            timer.start();
            timer.setRepeats(true);

        }
    }
}

class ReferenceWindow {
    public Window window;

    public ReferenceWindow(Window window) {
        this.window = window;
    }

    public void updateWindow(Window newWindow) {
        this.window.windowClose(); // Close current window
        this.window = newWindow; // Set new window
        this.window.configWindow();
        // Show new window
    }

    public Window getWindow() {
        return this.window;
    }
}