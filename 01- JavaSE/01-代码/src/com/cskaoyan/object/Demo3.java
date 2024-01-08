package com.cskaoyan.object;

/*
        public String toString()

        关于toString()方法的作用，在官方JDK文档中，有详细的说明，主要是以下四点：
        1. 返回该对象（调用toString方法的对象）的字符串表示。
        2. 通常，toString()方法"以文本方式表示"此对象的字符串。
        3. 结果应是一个简明但易于读懂的信息表达式。
        4. 建议所有子类都重写此方法。


        默认实现: getClass().getName() + '@' + Integer.toHexString(hashCode())

        什么可以表示一个对象的特征?  对象的成员变量值

 */
public class Demo3 {

    public static void main(String[] args) {

        ToStringClass obj = new ToStringClass(10,20);


        // Object方法toString默认实现
        String string = obj.toString();
        // com.cskaoyan.object.ToStringClass@1b6d3586
        System.out.println(string);
    }
}

class ToStringClass {

    int i;
    double j;

    public ToStringClass(int i, double j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "ToStringClass {i = "+ i + ", j = " + j+"}";
    }
}


