package com.student_info_processor;

import javax.swing.SwingUtilities;

import com.student_info_processor.Interface.Greeting;
import com.student_info_processor.Interface.Window;

public class MyApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Greeting greeting_window = new Greeting(500, 500, "Greeting");
            greeting_window.config();
        });

    }
}
