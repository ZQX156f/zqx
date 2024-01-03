package com.cskaoyan.oop.constructor;

/*

        练习：
    定义一个学生类，该类具有一个int属性age
    1.在测试类中写一个方法，交换两个Student对象的age属性
      请问能够交换成功吗？原因是什么？

    2.在测试类中写一个方法，交换两个Student对象的引用（地址）
      请问能够交换成功吗？原因是什么？

 */
public class EX3 {

    public static void main(String[] args) {
        MyStudent firstStudent = new MyStudent(1);
        MyStudent secondStudent = new MyStudent(2);

        // 调用方法交换两对象的age成员变量值
        //swapStudentAge(firstStudent, secondStudent);

        swapStudentReference(firstStudent, secondStudent);

        System.out.println("first: " + firstStudent.age);
        System.out.println("second: " + secondStudent.age);
    }


    public static void swapStudentAge(MyStudent first, MyStudent second) {
        int tmp = first.age;
        first.age = second.age;
        second.age = tmp;

    }


    public static void swapStudentReference(MyStudent first, MyStudent second) {
        MyStudent tmp = first;
        first = second;
        second = tmp;
    }
}

class MyStudent {

    int age;


    // alt + insert
    public MyStudent() {
    }

    public MyStudent(int age) {
        this.age = age;
    }

}
