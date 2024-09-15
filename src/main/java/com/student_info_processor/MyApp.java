package com.student_info_processor;

import javax.swing.*;
import com.student_info_processor.Interface.Check;
import com.student_info_processor.Interface.Greeting;
import com.student_info_processor.Interface.Window;
import com.student_info_processor.Interface.SignIn;

public class MyApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Create initial page and window
            String[] currentPage = { "Greeting" };// used to track the current page
            String[] nextPage = { "Greeting" };// used to change the page inside each window

            Window mainWindow = new Greeting(400, 400, "Student Info Processor", nextPage, currentPage);
            mainWindow.configWindow();

            // Create a ReferenceWindow instance
            ReferenceWindow referenceWindow = new ReferenceWindow(mainWindow);

            // Handle page switching
            new Thread(() -> handlePageSwitch(referenceWindow, currentPage, nextPage)).start();

            mainWindow = referenceWindow.window;

        });
    }

    private static Timer timer;

    private static void handlePageSwitch(ReferenceWindow referenceWindow, String[] currentPage, String[] nextPage) {
        // This method could be triggered by events or other mechanisms
        // Example page switch logic
        {

            timer = new Timer(500, e -> {
                if (!currentPage[0].equals(nextPage[0])) {
                    switch (nextPage[0]) {
                        case "Greeting":
                            currentPage[0] = "Greeting";
                            Window greeting = new Greeting(400, 400, "Student Info Processor", nextPage, currentPage);
                            referenceWindow.updateWindow(greeting);
                            break;

                        case "Check":
                            currentPage[0] = "Check";
                            Window check = new Check(400, 400, "Check", nextPage, currentPage);
                            referenceWindow.updateWindow(check);
                            break;

                        case "Closing":
                            System.exit(0);
                            break;

                        case "SignIn":
                            currentPage[0] = "SignIn";
                            Window signIn = new SignIn(400, 400, "Sign In", nextPage, currentPage);
                            referenceWindow.updateWindow(signIn);
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
}