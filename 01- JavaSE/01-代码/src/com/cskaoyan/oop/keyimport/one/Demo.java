package com.cskaoyan.oop.keyimport.one;

//import com.cskaoyan.oop.keyimport.another.Student;

// 智能导包
import com.cskaoyan.oop.keyimport.another.*;

// 静态导入
import static java.lang.System.out;
// 智能静态导入
import static java.lang.Math.*;
/*

    从上述案例中，我们可以总结一下编译器在查找并决定使用某个class时，它的搜索机制：
        - 在同包下时，类名是绝对唯一的，有就有，没有就没有，不存在选择的问题。
          1. 这时，编译器是可以直接通过一个类名去查找到一个类的，不需要额外操作，不需要导包。
          2. 这可以看成一种"就近原则"，同包已经存在这个类了，自然不需要去外面找。

        - 当同包下没有这个类，必须在不同包下寻找时，多个不同包中完全可能存在同名类。
          1. 这时，编译器肯定是不可能直接通过类名去查找一个类了，需要程序员手动导包。
          2. 手动导包的目的是明确告诉编译器应该使用哪个包下的类。

      语法:
        import 全限定类名;

     注意事项:
       1. package声明之后，有效代码之前。
       2. Java当中的，java.lang包是Java的核心类包，具有隐式的导包
       3. 实际上完全可以不导包去使用不同包下类，这时要明确指出这个类的所属包，也就是要使用全限定类名。
       4.

       智能导包: 按需导入
       import + 包名.*;

       静态导包: 它导入的是类中的静态成员
       import static 全类名.静态成员名
       System.out
 */



public class Demo {

    public static void main(String[] args) {

        // 访问同包中的Student
//        Student student = new Student();
//        student.test();

        // 使用import导入另外一个包中的类
        Student student = new Student();
        //student.test();


        // 按住ctrl，鼠标左键点击一个类的类名
        String string = new String();


        // 比如说我想同时使用两个Student
        // 同时使用多个同名类，只能import其中一个，剩下的就要使用全类名
        Student aontherStudent = new Student();

        com.cskaoyan.oop.keyimport.one.Student oneStudent
                = new com.cskaoyan.oop.keyimport.one.Student();


        // 智能导包方式使用另外一个包中的类
        A a = new A();
        B b = new B();
        Teacher teacher = new Teacher();

        Student st = new Student();
        //st.test(); //one package Student

        out.println("hello import static");

        // 访问Math类的静态成员变量
        //out.println(PI);
        double pow = pow(2, 2);
        out.println(pow);
    }
}
