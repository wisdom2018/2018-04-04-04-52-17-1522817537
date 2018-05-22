package com.tw.view;

import java.util.Scanner;

public class Main {
    public static final String ADD_STUDENT_FAILURE = "please input correct format add course";

    public static void main(String args[]) {
        Main main = new Main();

        StudentManagementUI studentManagementUI = new StudentManagementUI();
        studentManagementUI.mainSelect();
        studentManagementUI.setup();
        boolean flag = false;
        try {
            flag = studentManagementUI.verifyInputFormat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
