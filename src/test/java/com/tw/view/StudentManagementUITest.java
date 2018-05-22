package com.tw.view;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class StudentManagementUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    StudentManagementUI studentManagementUI;

    @Test
    public void printMainUI_test() {
        //studentManagementUI.printMainUI();
        //assertThat(out.toString(),containsString("选择"));
    }
}