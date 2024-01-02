package com.cskaoyan.oop.constructor;

/*


     对象的属性，能不能"出厂"的时候就设定好呢？
     想要在创建教师对象时，就直接指定这个对象的属性？

     可以，但是需要用到构造方法

     [访问权限修饰符] 类名(形参列表){
	    // 构造方法体 (通常主要就是接收参数，给成员变量)
	}
	1. 权限修饰符先使用public
    2. 构造方法名必须跟类名相同(一模一样,包括大小写)
    3. 构造方法没有返回值, 也不需要写返回值
    4. 形参列表可以为空, 称为无参构造方法,非空为有参构造方法
    5. 构造方法体，和一般方法类似，可以写语句
    6. 一个类中，是允许同时定义多个构造方法的，即构造方法重载，多个构造器的形参必须不同

	构造早方法的使用:
	  new 类名(实参列表);
	1. 我们开发者是无法直接调用构造方法的
	2. 使用new 类名(实参列表) 是在告诉jvm根据类型匹配，我们使用的是哪个构造方法
	3. new关键字去创建对象的时候，JVM自动去调用构造方法，构造方法无法通过普通方法的调用方式调用。
    4. 构造器的作用不是创建对象，创建对象是JVM的事情。构造器只是告诉JVM在创建对象过程中，给成员变量赋什么值。
    使用细节:
    1. 类中默认提供的无参构造方法，是在该类没有任何构造器的情况下才有的。但是如果类中有任一构造器（有参/无参），那么就没有默认无参存在了
    2. 在构造器中也会隐含this传参, 我们可利用this对成员变量进行赋值, 也可以使用快捷键, alt + insert快速生成构造器.
    3. 构造器中还可以用this表示调用其它构造器，语法：
      this(实参列表);
    4. 表示调用类中的其它构造器，根据实参列表决定调用哪个构造器。必须在第一行，那么也只能用一次了。


}
 */
public class Demo1 {

    public static void main(String[] args) {
        // 18岁的Java老师对象
        Teacher javaTecher = new Teacher();
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
        //firstTeacher.teach();

        //Teacher secondTeacher = new Teacher("C++", 28);
        //secondTeacher.teach();

        //Teacher thirdTeacher = new Teacher("Python", 30);
        //thirdTeacher.teach();

        //无法像调用成员方法或者"普通方法"一样，调用构造方法
        //thirdTeacher.Teacher();

    }
}


 class Teacher {

    String course;

    int age;

    public Teacher() {
        // 在构造方法中也可以访问到this
        //System.out.println(this.course);

        // 构造方法中，可以调用类中定义的其他成员方法
        //this.teach();

        System.out.println("default constructor");
    }

    // 定义构造方法
     public Teacher(String myCourse, int myAge) {
        // 调用无参构造方法
         this();
         // 自己在构造方法中完成成员变量的赋值语句, 构造方法中的this,表示的是当前正在创建的对象
         this.course = myCourse;

         age = myAge;
     }



    public void teach() {
        // this调用构造方法，只能写在构造方法中，
        //this();
        System.out.println(age + "的" + course + "老师在讲课");
    }
}
