package com.cskaoyan.oop2.encapsulate;


/*
      封装 = 类 + 类中成员访问权限
 */
public class Demo1 {

    public static void main(String[] args) {

        // 创建对象，是在录入学生信息
        Student student = new Student("zs", 19);

        // 没有权限
        //student.name = "ls";

        // set方法修改
        student.setName("ls");

        // get方法获取
        String name = student.getName();
        System.out.println(name);


        // public访问权限，随意访问
        student.studentId = 1;
        System.out.println(student.studentId);

        // 外界通过set方法修改成员变量值

    }

}

class Student {


    public int studentId;

    private String name;

    private int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        // 通过代码逻辑，控制对成员变量的访问
        if (name == null || name.equals("")) {
            return;
        }
        this.name = name;
    }



}
