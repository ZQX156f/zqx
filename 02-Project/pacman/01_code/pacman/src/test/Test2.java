package test;

/**
 * @ClassName Test2
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 10:23
 * @Version V1.0
 **/
public class Test2 {

    private static Animal animal;

    public static void main(String[] args) {
        //除了使用上述的这种方式之外，还有另外一种方式
        Dog dog = new Dog();
        dog.eat();

        Cat cat = new Cat();
        cat.eat();


        //就是使用父类指向子类实现的方式
        animal = new Dog();

        animal.eat();

        animal = new Cat();

        animal.eat();
    }
}
