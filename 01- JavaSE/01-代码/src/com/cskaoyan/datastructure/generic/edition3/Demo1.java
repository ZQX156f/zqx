package com.cskaoyan.datastructure.generic.edition3;


/*


 */
public class Demo1 {

    public static void main(String[] args) {

        // 全部指定每一个泛型类型的具体类型
        User<String, Integer, Float> first = new User<>();

        // 如果要指定使用的多个具体类型，要指定都指定
        //User<String> second = new User<>();

        // 也可以都不指定
        // 此时有类型都是Object类型
        User user = new User();


        // 使用泛型的时候，基本数据类型是不能用当做泛型类型的
        //  写包装类型即可
        User<Integer, Integer, Integer> third = new User<>();
    }
}

class User<T,E,V> {
    T t;
    E e;

    // 不能定义静态的泛型类型的变量
    //static V v1;

    static {
        // 不能在静态上下文中使用泛型
        //V v = 10;
    }

    public void method() {
        // 泛型类型无法直接new对象
        //T t1 = new T();
    }
}
