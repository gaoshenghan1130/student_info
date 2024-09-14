package com.student_info_processor;

import com.student_info_processor.Interface.Window;

public class MyApp {
    public static void main(String[] args) {
        Window window = new Window(1000,1000,"wind");
        window.windowOut();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.windowClose();
    }
}
