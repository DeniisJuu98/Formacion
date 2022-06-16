package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class MyClass {
    public static class Student {
        public String name;
        public int id;
        public String toString() { return "id = " + id;}
    };
    public static class StudentVO {
        public String name;
        StudentVO(Student s) {
            this.name = s.name + " " + s.id;
        }
        public String toString() { return "name = " + name;}
    };
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 1;
        s1.name = "Manolo";
        Student s2 = new Student();
        s2.id = 2;
        s2.name = "Paco";
        Student s3 = new Student();
        s3.id = 3;
        s3.name = "Manolo";
        List<Student> st = List.of(s1, s2, s3);

        System.out.print(st.stream()
                .filter(student -> student.name.equals("Manolo"))
                        .map(student -> new StudentVO(student).toString())
                .collect(Collectors.joining("|")));
    }
}
