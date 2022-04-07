package com.spring.test;

import java.util.ArrayList;
import java.util.List;

import static com.spring.test.Class.*;

public class Student {

    private String name;
    private int age;
    private List<Class> classes = new ArrayList<>();

    public Student() {
        initClasses();
    }

    public Student(String name, int age){
        if(age < 1){
            throw new IllegalArgumentException("나이는 0이상을 입력해야 합니다.");
        }
        initClasses();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void clearClasses() {
        this.classes.clear();
    }

    public void addClass(Class cls){
        this.classes.add(cls);
    }

    public void deleteClass(Class cls){
        this.classes.remove(cls);
    }

    private void initClasses() {
        classes.add(KOREAN);
        classes.add(MATH);
        classes.add(ENGLISH);
    }
}
