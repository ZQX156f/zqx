package com.cskaoyan.object;

import java.util.Objects;

/*
        protected native Object clone() throws CloneNotSupportedException;
        创建并返回此对象的一个副本

        使用clone方法会遇到问题：
        1. 访问权限问题
           a. Object类定义在java.lang, CloneClass定义以在com.cskaoyan.object
           b. 我们不能在Demo6中调用Demo6的兄弟类CloneClass继承的protected访问权限的成员
           c. 如果我们要调用另外一个类的clone方法，另外一个类，必须覆盖父类中的clone方法

        2. Cloneable接口的问题
           如果我们要成功调用一个类的clone方法，该类必须实现一个特殊的接口Cloneable

        3. 建议覆盖Object的clone方法，将方法返回值修改为具体类型


        空接口的意义:  空接口当做特殊的标记
 */
public class Demo6 {

    public static void main(String[] args) throws CloneNotSupportedException {

        //CloneClass cloneClass = new CloneClass();

        // 可以调用clone方法，其他类对象的克隆，其他类覆盖了父类中的clone
        //CloneClass cloneObj = cloneClass.clone();

        // 比较成员变量值是否相同
        //System.out.println(cloneObj.equals(cloneClass));
        //System.out.println(cloneObj == cloneClass);

        // 访问自己挎包子类继承的protected权限的成员方法
//        Demo6 demo6 = new Demo6();
//        demo6.clone();

        // 虽然Cloneable是一个空接口，但是类实现了Cloneable
        //Cloneable c = new CloneClass();
    }


}

class CloneClass implements Cloneable {

    int i;

    public CloneClass(int i) {
        this.i = i;
    }

    public void testAccess() throws CloneNotSupportedException {
       // 挎包访问父类中的protected访问权限的成员
       this.clone();


        //CloneClass cloneClass = new CloneClass();
        //// 访问自己挎包子类继承的protected权限的成员方法
        //cloneClass.clone();

    }

//    @Override
//    protected CloneClass clone() throws CloneNotSupportedException {
//        return (CloneClass) super.clone();
//    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneClass(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloneClass that = (CloneClass) o;
        return i == that.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
