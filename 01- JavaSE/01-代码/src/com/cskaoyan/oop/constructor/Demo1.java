package com.cskaoyan.oop.constructor;

/*


     对象的属性，能不能"出厂"的时候就设定好呢？
     想要在创建教师对象时，就直接指定这个对象的属性？

     可以，但是需要用到构造方法
 */
public class Demo1 {

    public static void main(String[] args) {
        // 18岁的Java老师对象
//        Teacher javaTecher = new Teacher();
//        javaTecher.course = "JAVA";
//        javaTecher.age = 18;

        // 28岁的C++老师对象
//        Teacher cppTeacher = new Teacher();
//        cppTeacher.course = "C++";
//        cppTeacher.age = 28;

        // 30岁的Python老师对象
//        Teacher pythonTeacher = new Teacher();
//        pythonTeacher.course = "Python";
//        pythonTeacher.age = 30;

        // 使用我们定义的两参构造方法
        Teacher firstTeacher = new Teacher("JAVA", 18);

        Teacher secondTeacher = new Teacher("C++", 28);

        Teacher teacher = new Teacher("Python", 30);

    }
}


 class Teacher {

    String course;

    int age;

    public Teacher() {

    }

    // 定义构造方法
     public Teacher(String myCourse, int myAge) {
         // 自己在构造方法中完成成员变量的赋值语句
         course = myCourse;
         age = myAge;
     }



    public void teach() {
        System.out.println(age + "的" + course + "老师在讲课");
    }
}
