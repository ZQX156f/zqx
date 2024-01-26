package supplement.reflect;

/**
 * @ClassName ReflectDemo1
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 11:28
 * @Version V1.0
 **/
public class ReflectDemo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        //如果希望获取Dog这个class文件里面的信息，我们应该获取Dog对应的Class对象
//        - 对象.getClass()
//                - 类名.class
//                - **Class.forName(String className)**  全限定名
        Dog dog = new Dog();
        Class<? extends Dog> aClass = dog.getClass();

        Class<Dog> dogClass = Dog.class;

        //里面编写它的全限定类名即可
        Class<?> aClass2 = Class.forName("supplement.reflect.Dog");


    }
}
