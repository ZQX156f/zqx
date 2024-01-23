package com.cskaoyan.datastructure.generic.edition1;

/*


        所谓泛型是参数化类型,
        1. 当我们在写某些代码逻辑的时候, 对于某个参数的类型不太确定,
           我们可以先假定一种类型来代指
        2. 当我们真正使用的时候, 再传入具体的类型(像传参一样: 所以叫参数化类型)

 */
public class Demo1 {

    public static void main(String[] args) {

        User<String> stringUser = new User<>();
        String a = stringUser.a;

        User<A> aUser = new User<>();
        A obj = aUser.a;
    }
}

class A {}

class User<XXXXX> {

    XXXXX a;

}
