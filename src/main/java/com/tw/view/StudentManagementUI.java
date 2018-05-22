package com.tw.view;

import com.tw.entity.Course;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class StudentManagementUI {
    public static final String ADD_STUDENT_FAILURE = "please input correct format add course";
    StudentManagementUI studentManagementUI;
    Course course = new Course();
    ArrayList<Course> courses = new ArrayList<Course>();
    ArrayList<String> allCouses = new ArrayList<>();
    HashMap<String, String> nameCourse = new HashMap<>();
    HashMap<Integer, String> courseMap = new HashMap<>();
    HashMap<String, ArrayList<String>> grades = new HashMap<>();

    HashMap<String, HashMap<String, Integer>> coursesMap = new HashMap<>();
    boolean flag = true;

    private BufferedReader bufferedReader;

    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    public void printMainUI() {
        System.out.println("1.添加学生");
        System.out.println("2.生成成绩单");
        System.out.println("3.退出");
        System.out.println("请输入你的选择（1-3）");
    }

    public void selectOfStudent(String select) {
        switch (select) {
            case "1":
                this.addStudent();                 //add student
                break;
            case "2":
                this.produceGradeList();           //produce student grade list
                break;
            case "3":                              //quit
                System.exit(0);
                break;
            default:
                this.printMainUI();
        }
    }


    public void mainSelect() {
        System.out.println(grades);
        String selection = "";
        do {
            printMainUI();
            selection = inputChoose();
            this.selectOfStudent(selection);
        } while (!selection.equals("q"));
    }

    public void addStudent() {
        System.out.println("请输入学生信息");
        try {
            flag = this.verifyInputFormat();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void produceGradeList() {
        System.out.println("请输入要打印学生的学号");
        System.out.println("成绩单");

        System.out.println("姓名" + "|" + "数学" + "|" + "语文" + "|" + "编程" + "|" + "平均分" + "|" + "总分");

        System.out.println("=========================================");
        this.printGradeList();
        grades = null;
        System.out.println("==========================================");
        System.out.println(" 全班总分平均数：");
        System.out.println("全班的总分中位数：");
    }
    public boolean verifyInputFormat() throws Exception {
        courses = course.setCourses();
        for (Course temp : courses) {
            courseMap.put(temp.getCourseId(), temp.getCourseName());
        }
        String input = "";
        input = bufferedReader.readLine();
        String[] inputArray = input.split(",");
        System.out.println(inputArray.length);
        String courseName;
        String courseGrade;
        String studentName = "";
        studentName = inputArray[0];
        for (int i = 0; i < inputArray.length; i++) {
            if (i >= 2) {
                if (!inputArray[i].contains(":")) {
                    flag = false;
                } else {
                    int temp = inputArray[i].indexOf(":");

                    courseName = inputArray[i].substring(0, temp);
                    courseGrade = inputArray[i].substring(temp + 1, inputArray[i].length());
                    nameCourse.put(courseName, courseGrade);
                    if (courseMap.containsValue(courseName)) {
                        System.out.println(courseName);
                        System.out.println(courseGrade);
                        if (Integer.valueOf(courseGrade) >= 0 && Integer.valueOf(courseGrade) <= 100) {
                            allCouses.add(courseGrade);
                        } else {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                }
            }
        }
        if (flag) {
            System.out.println("学生" + studentName + "的成绩被添加");
            grades.put(studentName, allCouses);
            System.out.println(grades);
        } else {
            System.out.println(ADD_STUDENT_FAILURE);
        }
        return flag;
    }

    public String inputChoose() {
        Scanner sc = new Scanner(System.in);
        String selection = sc.next();
        return selection;
    }

    public void printGradeList() {
        int courseNumber = 0;
        double total = 0;
        double average = 0.0;
        Iterator<Map.Entry<String, ArrayList<String>>> entries = grades.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, ArrayList<String>> entry = entries.next();
            System.out.print(entry.getKey() + "|");
            for (String temp : entry.getValue()
                    ) {
                System.out.print(temp + "|");
                courseNumber++;
                total += Integer.valueOf(temp);
            }
            average = total / courseNumber;
            System.out.print(average + "|");
            System.out.println(total);
        }
        grades.clear();
        nameCourse.clear();
    }
}

//li,2,math:90,chinese:80,english:90
//zhang,1,math:80,chinese:90,english:90