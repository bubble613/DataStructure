package com.LWY.designPattern;

import java.util.ArrayList;
import java.util.List;

public class VisitorParttern {
    public static void main(String[] args) {
        PersonStructure structure = new PersonStructure();

        Visitor1 visitor1 = new Visitor1();
        System.out.println("访问者1的访问记录：");

        structure.Accept(visitor1);

        System.out.println("==================================");

        Visitor2 visitor2 = new Visitor2();
        System.out.println("访问者2的访问记录:");

        structure.Accept(visitor2);
    }
}

interface Visitor {
    void visitStudent(Student student);

    void visitTeacher(Teacher teacher);
}

class Visitor1 implements Visitor {


    @Override
    public void visitStudent(Student student) {
        System.out.println("访问者1访问学生" + student.name);
    }

    @Override
    public void visitTeacher(Teacher teacher) {
        System.out.println("访问者1访问老师" + teacher.name);
    }
}


class Visitor2 implements Visitor {


    @Override
    public void visitStudent(Student student) {
        System.out.println("访问者2访问学生" + student.name);
    }

    @Override
    public void visitTeacher(Teacher teacher) {
        System.out.println("访问者2访问老师" + teacher.name);
    }
}

class PersonStructure {
    private List<person> personList = new ArrayList<person>();

    public PersonStructure() {
        personList.add(new Student("张三"));
        personList.add(new Student("李四"));
        personList.add(new Student("王五"));

        personList.add(new Teacher("李老师"));
        personList.add(new Teacher("刘老师"));
        personList.add(new Teacher("王老师"));
    }

    public void Accept(Visitor visitor) {
        for (person personelem : personList) {
            personelem.accept(visitor);
        }
    }
}

abstract class person {
    public String name;

    public abstract void accept(Visitor visitor);
}

class Student extends person {

    public Student(String name) {
        this.name = name;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitStudent(this);
    }
}

class Teacher extends person {

    public Teacher(String name) {
        this.name = name;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitTeacher(this);
    }
}

