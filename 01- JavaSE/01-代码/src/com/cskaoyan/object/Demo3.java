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

        两种典型的使用场景:
        1. 输出一个对象
        2. 字符串的拼接

        注意事项:
          1. toString()方法，普遍来说就是为了完成打印成员变量取值的，不要在里面写一些奇怪的代码。
             因为在debug运行时，IDEA会自动调用toString()
          2. 如果类中有（自定义）引用数据类型成员变量，也需要重写它的toString方法，不然就会打印地址值了。
          3. IDEA 生成 快捷键 alt + insert


 */
public class Demo3 {

    public static void main(String[] args) {

        Star star = new Star("zs");
        ToStringClass obj = new ToStringClass(10,20, star);


        // Object方法toString默认实现
        //String string = obj.toString();
        // com.cskaoyan.object.ToStringClass@1b6d3586
        //System.out.println(string);


        // 输出 对象的toString方法的结果
        System.out.println(obj);

        // 字符串
        //String s = "hello, ";
        //System.out.println(s + obj);

        // 在debug时，不要在toString方法中写其他
//        Star s = new Star("李四");
//        System.out.println(s.name);
    }
}

class ToStringClass {

    int i;
    double j;

    Star star;

    public ToStringClass(int i, double j) {
        this.i = i;
        this.j = j;
    }

    public ToStringClass(int i, double j, Star star) {
        this.i = i;
        this.j = j;
        this.star = star;
    }


    // IDEA 生成 快捷键 alt + insert
    @Override
    public String toString() {
        return "ToStringClass{" +
                "i=" + i +
                ", j=" + j +
                ", star=" + star +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "ToStringClass {i = "+ i + ", j = " + j + ", stat = " + star +"}";
//    }
}

class Star {
    String name;
    public Star(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        name = "张三";
        return "Star{" +
                "name='" + name + '\'' +
                '}';
    }
}


