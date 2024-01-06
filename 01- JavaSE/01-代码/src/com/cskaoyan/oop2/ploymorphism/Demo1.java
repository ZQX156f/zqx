package com.cskaoyan.oop2.ploymorphism;


/*

        多态的发生条件
        根据上述定义，总结一下Java中多态发生的条件：

        1. 必须存在继承，多态一定发生在父子类之间。
        2. 必须存在方法重写，不同的子类需要重写父类中的同名方法。
        3. 必须存在父类引用指向子类对象

        Huawei, XiaoMi, Iphone

        多态成员的访问特征:
        成员变量: 编译看左边，运行看左边
        编译看左边：通过引用变量，可以访问到的成员范围，是由引用变量的类型决定
        运行看左边: 实际访问到的，同名成员变量的结果，也和引用变量

        成员方法：编译看左边，运行看右边
        编译看左边: 通过引用变量，可以访问到的成员范围，是由引用变量的类型决定
        运行看右边: 实际访问到的方法，由引用变量实际指向的对象决定
 */
public class Demo1 {

    public static void main(String[] args) {

        // 测试多态效果
        // testPolymorphism();

        // 多态成员的访问特征

        // 1. 成员变量
        //  编译看左边，运行看左边
        Phone phone = new HuaweiPhone();
        //System.out.println(phone.name);
        // 访问不到子类独有的成员变量
        //System.out.println(phone.a);
        phone.assist();

        phone = new XiaomiPhone();
        //System.out.println(phone.name);
        phone.assist();

        phone = new IPhone();
        //System.out.println(phone.name);
        phone.assist();
    }

    private static void testPolymorphism() {
        Phone phone = null;

        // 指向华为手机对象
        phone = new HuaweiPhone();
        phone.assist();

        // 指向小米手机
        phone = new XiaomiPhone();
        phone.assist();

        // 指向iphone
        phone = new IPhone();
        phone.assist();


        Phone phone1 = new Phone();
        HuaweiPhone huaweiPhone = new HuaweiPhone();
        XiaomiPhone xiaomiPhone = new XiaomiPhone();
        IPhone iPhone = new IPhone();


        testPolymorphism(phone1);
        testPolymorphism(huaweiPhone);
        testPolymorphism(xiaomiPhone);
        testPolymorphism(iPhone);
    }


    public static void testPolymorphism(Phone phone) {
        phone.assist();
    }

}

class Phone {

    String name = "phone";

    public void assist() {
        System.out.println("唤醒手机助手");
    }
}

class HuaweiPhone extends Phone {

    String name = "HuaweiPhone";

    int a;

    @Override
    public void assist() {
        System.out.println("小易，小易");
    }
}

class XiaomiPhone extends Phone {

    String name = "XiaomiPhone";
    @Override
    public void assist() {
        System.out.println("小爱同学");
    }
}

class IPhone extends Phone {

    String name = "IPhone";

    @Override
    public void assist() {
        System.out.println("嘿siri");
    }

}
